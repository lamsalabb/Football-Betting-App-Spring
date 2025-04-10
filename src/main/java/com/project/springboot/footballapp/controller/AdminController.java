package com.project.springboot.footballapp.controller;

import com.project.springboot.footballapp.entity.User;
import com.project.springboot.footballapp.entity.Role;
import com.project.springboot.footballapp.repository.RoleRepository;
import com.project.springboot.footballapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleRepository roleRepository;

    @Autowired
    public AdminController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/list")
    public String configUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int id, Model theModel) {

        User user = userService.findById(id);
        System.out.println(user);
        theModel.addAttribute("user", user);

        return "admin/update";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        System.out.println(user+"user in save");
        String tempBCryptPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword("{bcrypt}" + tempBCryptPass);
        userService.save(user);
        //TODO NOT LETTING UPDATE FROM ADMIN BUT WORKS FROM USER
        return "redirect:/admin/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int id) {


        User user = userService.findById(id);
        roleRepository.deleteById(user.getUsername());
        userService.deleteById(id);

        return "redirect:/admin/list";

    }
}
