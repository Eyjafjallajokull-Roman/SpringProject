package com.example.SpringProject.repository;

import com.example.SpringProject.model.FileMultipart;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FileMultipartRepository extends JpaRepository<FileMultipart,String>  {

}
