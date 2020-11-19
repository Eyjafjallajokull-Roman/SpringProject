package com.example.SpringProject.controller;

import com.example.SpringProject.model.EducationInstitution;
import com.example.SpringProject.service.EducationInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/institution/delete/{id}")
    public String deleteProduct (@PathVariable int id){
        service.delete(id);
        return "redirect:/";
    }
    
    @GetMapping("/institution/update/{id}")
    public String updateInstitut(@PathVariable int id,Model model){
        model.addAttribute("service",service.findOne(id));
        return "update";
    }

    @PostMapping("/institution/update/{id}")
    public String updateInstitut(@PathVariable int id, @RequestParam String name,@RequestParam int accreditation,@RequestParam int numberOfStudents
    , @RequestParam int numberOfUniversity, @RequestParam String addressUniversity){
       service.save(new EducationInstitution(id,name,accreditation,numberOfStudents,numberOfUniversity,addressUniversity));
        return "redirect:/";
    }

    @GetMapping("/institution/create")
    public String createInstitu(){

        return "create";
    }

    @PostMapping("/institution/create")
    public String createInstitut( @RequestParam String name,@RequestParam int accreditation,@RequestParam int numberOfStudents
            , @RequestParam int numberOfUniversity, @RequestParam String addressUniversity){
        service.save(new EducationInstitution(name,accreditation,numberOfStudents,numberOfUniversity,addressUniversity));
        return "redirect:/";
    }


}
