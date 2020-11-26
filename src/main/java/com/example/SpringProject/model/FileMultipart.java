package com.example.SpringProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "files")
public class FileMultipart {
    @Id
    @JsonIgnore
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_type")
    private String fileType;
    @Column(name = "size")
    private long size;
    @Lob
    @Column(name = "data")
    @JsonIgnore
    private byte[] data;

    private String downloadUrl;

    public FileMultipart(String fileName, String fileType, long size, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.size = size;
        this.data = data;
    }
}
