package com.project.springboot.footballapp.controller;

import com.project.springboot.footballapp.entity.User;
import com.project.springboot.footballapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/list")
    public String configUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "admin/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId,
                                    Model theModel) {

        User user = userService.findById(theId);

        theModel.addAttribute("user", user);

        return "register";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println("saving user");
        userService.save(user);

        return "redirect:/admin/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int theId) {

        userService.deleteById(theId);

        return "redirect:/admin/list";

    }
}
