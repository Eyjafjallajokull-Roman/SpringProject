package com.example.SpringProject.repository;

import com.example.SpringProject.model.FileMultipart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMultipartRepository extends JpaRepository<FileMultipart,Long> {

}
