package com.example.SpringProject.repository;



import com.example.SpringProject.model.EducationInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationInstitutionRepository extends JpaRepository<EducationInstitution, Integer> {
    List<EducationInstitution> findAllByAccreditationOrderByIdDesc(Integer accreditation);

    List<EducationInstitution> findAllByNumberOfStudentsAndNumberOfUniversity(Integer numberOfStudents, Integer numberOfUniversity);

    List<EducationInstitution> findAllByAddressUniversity(String addressUniversity);

    List<EducationInstitution> findAllByNumberOfStudentsLessThanAndNumberOfStudentsGreaterThan(Integer numberOfStudents, Integer numberOfStudents2);
}
