package com.project.springboot.footballapp.service;

import com.project.springboot.footballapp.entity.Bet;
import com.project.springboot.footballapp.entity.User;
import com.project.springboot.footballapp.repository.BetRepository;
import com.project.springboot.footballapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BetServiceImpl implements BetService {

    private BetRepository betRepository;

    private UserRepository userRepository;

    @Autowired
    public BetServiceImpl(BetRepository betRepository,UserRepository userRepository){
        this.betRepository=betRepository;
        this.userRepository=userRepository;
    }

    public void checkAndProcessPayouts() {
        List<Bet> pendingBets = betRepository.findByResultCheckedFalse();

        for (Bet bet : pendingBets) {
            if (isTimeToPayout(bet)) {
                processPayout(bet);
            }
        }
    }

    private boolean isTimeToPayout(Bet bet) {
        return LocalDateTime.now().isAfter(bet.getMatchTime().plusMinutes(180));
    }

    private void processPayout(Bet bet) {
        int actualHome = bet.getActualHomeScore();
        int actualAway = bet.getActualAwayScore();

        boolean isCorrect = bet.getPredictedHomeScore() == actualHome &&
                bet.getPredictedAwayScore() == actualAway;

        double payout = isCorrect ? bet.getBetAmount() * 2 : 0;

        User user = bet.getUser();
        if (user != null && payout > 0) {
            user.setBetCoins(user.getBetCoins() + (int) payout);
            userRepository.save(user);
        }

        bet.setResultChecked(true);
        bet.setPayout((int) payout);
        betRepository.save(bet);
    }
}
