package com.project.springboot.footballapp.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.project.springboot.footballapp.utils.APIReturn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
        public String showHome(Model model){
            JsonNode fixtures = APIReturn.getUpcomingFixtures();

        List<Map<String, Object>> fixtureList = new ArrayList<>();
        Instant now = Instant.now();
        Instant fixtureTime;
        for(JsonNode fixture : fixtures){
            fixtureTime=Instant.parse(fixture.path("utcDate").asText());
            if(now.isBefore(fixtureTime)){
                fixtureList.add(Map.of(
                        "homeTeam", fixture.path("homeTeam").path("name").asText(),
                        "awayTeam", fixture.path("awayTeam").path("name").asText(),
                        "date", ZonedDateTime.ofInstant(fixtureTime, ZoneId.systemDefault()).format(DateTimeFormatter.BASIC_ISO_DATE)
                ));

            }

        }

        model.addAttribute("fixtureList",fixtureList);
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
        JsonNode table = APIReturn.getTable();

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

