package com.example.SpringProject.controller;

import com.example.SpringProject.model.FileMultipart;
import com.example.SpringProject.service.FileMultipartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileMultipartController {
    @Autowired
    private FileMultipartService fileMultipartService;

    @PostMapping("/uploadFile")
    public FileMultipart uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        FileMultipart savedFileMultipart = fileMultipartService.save(multipartFile);
        savedFileMultipart.setDownloadUrl(buildDownload(savedFileMultipart.getId()));
        return savedFileMultipart;
    }

    @GetMapping("/files")
    public List<FileMultipart> findAllFiles(){
        List<FileMultipart> fileMultiparts =  fileMultipartService.findAll();
        fileMultiparts.forEach(fileMultipart -> fileMultipart.setDownloadUrl(buildDownload(fileMultipart.getId())));
       return fileMultipartService.findAll();
    }

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") String id){
        FileMultipart fileMultipart = fileMultipartService.findOne(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileMultipart.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + fileMultipart.getFileName() + "\"")
                .body(new ByteArrayResource(fileMultipart.getData()));
    }

   @PostMapping("/uploadMultipleFiles")
    public String uploadMultipleFiles(@RequestParam("file") MultipartFile[] multipartFiles){
        Arrays.asList(multipartFiles).forEach(multipartFile -> {
            try {
                uploadFile(multipartFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
   return "good" ;}

    private String buildDownload(String id){
       return ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/downloadFile/")
                .path(id)
                .toUriString();
    }
}
