package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.service.EcommerceService;

@Controller
public class AuthController {

    @Autowired
    private EcommerceService service;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("cartSize", service.getCart().getTotalItems());
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("cartSize", service.getCart().getTotalItems());
        return "signup";
    }

    @PostMapping("/signup")
    public String register(@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model) {
        User user = service.registerUser(username, email, password);
        model.addAttribute("message", "Registration successful! Please login.");
        model.addAttribute("cartSize", service.getCart().getTotalItems());
        return "login";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        // In a real app, get current user from security context
        User user = service.findUserByUsername("user");
        model.addAttribute("user", user);
        model.addAttribute("cartSize", service.getCart().getTotalItems());
        return "profile";
    }
}
