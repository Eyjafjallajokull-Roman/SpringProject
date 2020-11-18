package com.example.SpringProject.controller;

import com.example.SpringProject.service.EducationInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class EducationInstitutionMvcController {
    @Autowired
    private EducationInstitutionService service;

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("institutions", service.findAll());
        return "index";
    }
}
