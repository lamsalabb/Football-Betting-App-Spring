package com.project.springboot.footballapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
        public String showHome(){
            return "home";
        }

    @GetMapping("/showMyAccountPage")
    public String showMyAccountPage() {
        return "account";
    }
    @GetMapping("/showMyBetsPage")
    public String showMyBetsPage() {
        return "bets";
    }
    @GetMapping("/showStandingsPage")
    public String showStandings() {
        return "standings";
    }
    }

