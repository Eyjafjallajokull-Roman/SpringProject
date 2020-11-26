package com.example.SpringProject.service;

import com.example.SpringProject.model.FileMultipart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileMultipartService {
    List<FileMultipart> findAll();

    FileMultipart save(MultipartFile multipartFile) throws IOException;

    FileMultipart findOne(String id);





}
