package com.karol.lab.controller;

import com.karol.lab.model.User;
import com.karol.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new User());
        return "registrer";
    }

    public String registredUser(@ModelAttribute("user") User user, Model model){
        String result = userService.registerUser(user);
        model.addAttribute("messages",result);
        if (result.equals("success")){
            return "redirect:/login";
        }
        return  "register";
    }
}
