package com.karol.lab.controller;

import com.karol.lab.model.User;
import com.karol.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

   @PostMapping("/register")
    public String registredUser(@ModelAttribute("user") User user, Model model, RedirectAttributes redirectAttributes){
        String result = userService.registerUser(user);
        model.addAttribute("messages",result);
        if (result.equals("success")){
            redirectAttributes.addFlashAttribute("message", "Rejestracja zakończona sukcesem. Teraz możesz się zalogować.");
            return "redirect:/login";
        }else {
            model.addAttribute("message", "Rejestracja nie powiodła się. Nazwa użytkownika jest już zajęta.");
            return "register";
        }
        //return  "register";
    }
}
