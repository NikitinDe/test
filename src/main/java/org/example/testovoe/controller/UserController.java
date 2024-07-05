package org.example.testovoe.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/hello")
    public String hello(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "hello";
    }
    @GetMapping("/fe")
    public String frontendPage(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "frontend";
    }

    @GetMapping("/be")
    public String backendPage(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "backend";
    }

    @GetMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "admin";
    }
}
