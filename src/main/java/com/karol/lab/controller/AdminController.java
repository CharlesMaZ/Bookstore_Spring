package com.karol.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/adminpanel")
    public String adminpanel() {
        return "adminpanel";
    }

}
