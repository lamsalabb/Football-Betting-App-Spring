package com.project.springboot.footballapp.service;
import com.project.springboot.footballapp.entity.Bet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OddsService {


    private double calculateHomeWinOdds(Bet match) {
        return 1.5;  // Placeholder
    }

    private double calculateDrawOdds(Bet match) {
        return 3.5;
    }

    private double calculateAwayWinOdds(Bet match) {
        return 4.5;
    }
}
