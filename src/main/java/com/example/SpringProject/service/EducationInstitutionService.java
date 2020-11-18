package com.example.SpringProject.service;





import com.example.SpringProject.model.EducationInstitution;

import java.util.List;

public interface EducationInstitutionService {
List<EducationInstitution> findAll();

    EducationInstitution findOne(Integer id);

    EducationInstitution save(EducationInstitution educationInstitution);

    void delete(Integer id);

    List<EducationInstitution> findAllByAccreditation(Integer accreditation);

    List<EducationInstitution> findAllByNumberOfStudentsAndNumberOfUniversity(Integer numberOfStudents, Integer numberOfUniversity);

    List<EducationInstitution> findAllByAddressUniversity(String addressUniversity);

    List<EducationInstitution> findAllByNumberOfStudentsBetween(Integer numberOfStudents, Integer numberOfStudents2);


}
