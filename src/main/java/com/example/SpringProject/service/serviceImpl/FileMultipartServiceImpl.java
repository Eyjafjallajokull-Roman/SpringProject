package com.example.SpringProject.service.serviceImpl;

import com.example.SpringProject.model.FileMultipart;
import com.example.SpringProject.repository.FileMultipartRepository;
import com.example.SpringProject.service.FileMultipartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class FileMultipartServiceImpl implements FileMultipartService {

    @Autowired
    FileMultipartRepository fileMultipartRepository;

    @Override
    public List<FileMultipart> findAll() {
        return fileMultipartRepository.findAll();
    }

    @Override
    public FileMultipart save(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename()); //clean path - назва самого файлу, getOriginalFileName його шлях повний
        FileMultipart fileMultipart = new FileMultipart("", multipartFile.getContentType(), multipartFile.getSize(), multipartFile.getBytes());
        return fileMultipartRepository.save(fileMultipart);
    }

    @Override
    public FileMultipart findOne(long id) {
        return fileMultipartRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
