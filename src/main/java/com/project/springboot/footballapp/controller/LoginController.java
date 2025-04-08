package com.project.springboot.footballapp.controller;

import com.project.springboot.footballapp.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Year;

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
        return "register";
    }


    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }
}
