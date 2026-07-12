package org.assetflow.controller;

import org.assetflow.entity.User;
import org.assetflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showLoginPage() {
        return "index";
    }

    @PostMapping("/signup")
    public String processSignup(@ModelAttribute User user) {
        // The @ModelAttribute automatically maps the form fields (name, email, password) to the User object
        userService.registerEmployee(user);

        // Redirect back to the login page after a successful signup
        return "redirect:/";
    }
}