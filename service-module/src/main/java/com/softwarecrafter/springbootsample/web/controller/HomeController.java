package com.softwarecrafter.springbootsample.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author roman (romanzimnik) from software-crafter.com
 */

@org.springframework.stereotype.Controller
public class HomeController {

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}
