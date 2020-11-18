package com.example.SpringProject.controller;


import com.example.SpringProject.model.EducationInstitution;
import com.example.SpringProject.service.EducationInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution")
public class EducationInstitutionController {
    @Autowired
    private EducationInstitutionService service;

@PostMapping("/create")
    public ResponseEntity<EducationInstitution> create(@RequestBody EducationInstitution educationInstitution){
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(educationInstitution));
}
    @GetMapping("/")
    public ResponseEntity<List<EducationInstitution>> getAll(){
        List<EducationInstitution> educationInstitutions = service.findAll();
        return ResponseEntity.ok(educationInstitutions);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct (@PathVariable int id){
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EducationInstitution> updateProduct(@RequestBody EducationInstitution educationInstitution, @PathVariable int id){
        service.findOne(id);
        educationInstitution.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(educationInstitution));
    }

}
