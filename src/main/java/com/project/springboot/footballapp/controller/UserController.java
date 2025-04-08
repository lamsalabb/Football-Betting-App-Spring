package com.project.springboot.footballapp.controller;

import com.project.springboot.footballapp.entity.Role;
import com.project.springboot.footballapp.entity.User;
import com.project.springboot.footballapp.repository.RoleRepository;
import com.project.springboot.footballapp.service.UserService;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    private RoleRepository roleRepository;

    @Autowired
    public UserController(UserService userService,RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository=roleRepository;

    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {

        //TODO make coins for User
        String tempBCryptPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword("{bcrypt}"+tempBCryptPass);
        user.setActive(1);

        Role role= new Role(user.getUsername(),"ROLE_USER");//mapping manually

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
