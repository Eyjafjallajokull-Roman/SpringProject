package com.example.SpringProject.controller;


import com.example.SpringProject.model.EducationInstitution;
import com.example.SpringProject.service.EducationInstitutionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@ApiIgnore
@Api() //документація своя
@RequestMapping("/institution")
public class EducationInstitutionController {
    @Autowired
    private EducationInstitutionService service;


    @GetMapping("/")
    public ResponseEntity<List<EducationInstitution>> getAll(){
        List<EducationInstitution> educationInstitutions = service.findAll();
        return ResponseEntity.ok(educationInstitutions);
    }



}
