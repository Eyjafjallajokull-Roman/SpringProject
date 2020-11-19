package com.example.SpringProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@AllArgsConstructor
@Entity
@ToString
@Table(name = "education_institution")
public class EducationInstitution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "accreditation")
    private Integer accreditation;
    @Column(name = "number_of_students")
    private Integer numberOfStudents;
    @Column(name = "number_of_university")
    private Integer numberOfUniversity;
    @Column(name = "address_university")
    private String addressUniversity;

    public EducationInstitution() {
    }

    public EducationInstitution(String name, Integer accreditation, Integer numberOfStudents, Integer numberOfUniversity, String addressUniversity) {
        this.name = name;
        this.accreditation = accreditation;
        this.numberOfStudents = numberOfStudents;
        this.numberOfUniversity = numberOfUniversity;
        this.addressUniversity = addressUniversity;
    }

    public Integer getId() {
        return id;
    }

    public EducationInstitution setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EducationInstitution setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAccreditation() {
        return accreditation;
    }

    public EducationInstitution setAccreditation(Integer accreditation) {
        this.accreditation = accreditation;
        return this;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public EducationInstitution setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public Integer getNumberOfUniversity() {
        return numberOfUniversity;
    }

    public EducationInstitution setNumberOfUniversity(Integer numberOfUniversity) {
        this.numberOfUniversity = numberOfUniversity;
        return this;
    }

    public String getAddressUniversity() {
        return addressUniversity;
    }

    public EducationInstitution setAddressUniversity(String addressUniversity) {
        this.addressUniversity = addressUniversity;
        return this;
    }

}
