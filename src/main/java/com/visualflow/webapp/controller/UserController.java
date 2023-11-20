package com.visualflow.webapp.controller;

import com.visualflow.webapp.model.User;
import com.visualflow.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String viewList(Model model){
        List<User> userList = userService.allList();
        model.addAttribute("userlists",userList);
        return "users";
    }

    @GetMapping("/users/new")
    public String createNewUser(Model model){
        model.addAttribute("user", new User());
        return "user_form";
    }
}
