package com.example.SpringProject.controller;

import com.example.SpringProject.model.User;
import com.example.SpringProject.repository.UserRepository;
import com.example.SpringProject.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/registration")
    private String registration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    private String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors())
        {
            return "registration";
        }
        service.save(user);
        return "redirect:/welcome";
    }

    @GetMapping("/login")
    private String registration(Model model,String logout, String error){
        if (error != null){
            model.addAttribute("error", "UserName or password is incorrect");
        }
        if (logout != null){
            model.addAttribute("message", "you have been logged out");
        }

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/anonymous")
    public String anonymous() {
        return "anonymous";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
