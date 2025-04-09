package com.project.springboot.footballapp.controller;

import com.project.springboot.footballapp.entity.Role;
import com.project.springboot.footballapp.entity.User;
import com.project.springboot.footballapp.repository.RoleRepository;
import com.project.springboot.footballapp.service.EmailService;
import com.project.springboot.footballapp.service.UserService;
import com.project.springboot.footballapp.utils.OTPGenerator;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    private RoleRepository roleRepository;
    private EmailService emailService;

    @Autowired
    public UserController(UserService userService, RoleRepository roleRepository, EmailService emailService) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.emailService = emailService;

    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, Model model, @RequestParam(value = "otp", required = false) String otp) {

        if (otp == null || otp.isEmpty()) {
            String sentOtp = emailService.generateAndSendOTP(user.getEmail());
            model.addAttribute("otpSent", true);
            model.addAttribute("user", user);
            return "register";
        }

        boolean isOtpValid = emailService.validateOTP(user.getEmail(), otp);

        if (!isOtpValid) {
            model.addAttribute("otpError", "Invalid OTP entered! Please try again.");
            return "register";
        }


        String tempBCryptPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword("{bcrypt}" + tempBCryptPass);
        user.setActive(1);

        Role role = new Role(user.getUsername(), "ROLE_USER");//mapping manually because the db is too much hassle to link
        //hibernate not complying

        roleRepository.save(role);
        System.out.println(user);
        userService.save(user);
        return "login";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute("user") User user) {

        userService.delete(user);

        return "login";

    }
}
