package com.project.springboot.footballapp.controller;

import com.project.springboot.footballapp.entity.Bet;
import com.project.springboot.footballapp.entity.User;
import com.project.springboot.footballapp.repository.BetRepository;
import com.project.springboot.footballapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.security.Principal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/bet")
public class BetController {

    private BetRepository betRepository;

    private UserRepository userRepository;

    @Autowired
    public BetController(BetRepository betRepository,UserRepository userRepository){
        this.betRepository=betRepository;
        this.userRepository=userRepository;
    }

    @GetMapping("/showBetForm")
    public String showBetForm(@RequestParam String homeTeam, @RequestParam String awayTeam,@RequestParam String matchTime,@RequestParam Integer id, Model model) {
        Bet bet = new Bet();
        bet.setHomeTeam(homeTeam);
        bet.setAwayTeam(awayTeam);
        bet.setMatchId(Long.valueOf(id));
        System.out.println(Long.valueOf(id));
        Instant instant = Instant.parse(matchTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnn");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        bet.setMatchTime(localDateTime);

        System.out.println(localDateTime.withSecond(5).withNano(5));
        System.out.println(bet.getPlacedAt());


        model.addAttribute("bet", bet);
        return "bets";
    }

    @PostMapping("/place")
    public String placeBet(@ModelAttribute("bet") Bet bet, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());

        if (user.getBetCoins() < bet.getBetAmount()) {
            return "redirect:/error/insufficient-coins";
        }

        user.setBetCoins(user.getBetCoins() - bet.getBetAmount());
        bet.setUser(user);

        betRepository.save(bet);
        userRepository.save(user);

        return "redirect:/bet/showMyBetsPage";
    }

    @GetMapping("/showMyBetsPage")
    public String viewMyBets(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);

        List<Bet> userBets = betRepository.findByUser(user);

        model.addAttribute("bets", userBets);

        return "mybets";
    }
}
