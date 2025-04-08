package com.project.springboot.footballapp.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.project.springboot.footballapp.utils.StandingsAPIReturn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public String showStandings(Model model) {
        JsonNode table = StandingsAPIReturn.getTable();

        List<Map<String, Object>> teams = new ArrayList<>();

        for (JsonNode teamNode : table) {
            teams.add(Map.of(
                    "position", teamNode.path("position").asInt(),
                    "teamName", teamNode.path("team").path("name").asText(),
                    "playedGames", teamNode.path("playedGames").asInt(),
                    "won", teamNode.path("won").asInt(),
                    "draw", teamNode.path("draw").asInt(),
                    "lost", teamNode.path("lost").asInt(),
                    "points", teamNode.path("points").asInt(),
                    "goalsFor", teamNode.path("goalsFor").asInt(),
                    "goalsAgainst", teamNode.path("goalsAgainst").asInt()

            ));
        }

        model.addAttribute("teams", teams);
        return "standings";
    }
    }

