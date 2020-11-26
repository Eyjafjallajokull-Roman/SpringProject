package com.example.SpringProject.controller;

import com.example.SpringProject.model.FileMultipart;
import com.example.SpringProject.service.FileMultipartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class FileMultipartController {
    @Autowired
    private FileMultipartService fileMultipartService;

    @PostMapping("/uploadFile")
    public FileMultipart uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return fileMultipartService.save(multipartFile);
    }

    @GetMapping("/files")
    public List<FileMultipart> findAllFiles(){
       return fileMultipartService.findAll();
    }
}
