package com.project.springboot.footballapp.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.project.springboot.footballapp.entity.User;
import com.project.springboot.footballapp.utils.APIReturn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login";
    }

    @GetMapping("/showRegisterPage")
    public String showRegisterPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        JsonNode table = APIReturn.getTable();
        List<String> teams = new ArrayList<>();

        for(JsonNode team:table){
            teams.add(team.path("team").path("name").asText());
        }
        teams.sort(String.CASE_INSENSITIVE_ORDER);
        model.addAttribute("teams",teams);
        return "register";
    }


    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }

    @GetMapping("/showMyUpdatePage")
    public String showUpdatePage(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        System.out.println(user);
        return "update";
    }
}
