package com.visualflow.webapp.controller;

import com.visualflow.webapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/openHome")
    public String getHomePage(Model model){
        model.addAttribute("hello","Value Changed");
        return "index";
    }
}
