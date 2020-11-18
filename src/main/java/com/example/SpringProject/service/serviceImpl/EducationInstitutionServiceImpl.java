package com.example.SpringProject.service.serviceImpl;



import com.example.SpringProject.model.EducationInstitution;
import com.example.SpringProject.repository.EducationInstitutionRepository;
import com.example.SpringProject.service.EducationInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationInstitutionServiceImpl implements EducationInstitutionService {

    @Autowired
    private EducationInstitutionRepository educationInstitutionRepository;

    @Override
    public List<EducationInstitution> findAll() {
        return educationInstitutionRepository.findAll();
    }

    @Override
    public EducationInstitution findOne(Integer id) {
        return educationInstitutionRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public EducationInstitution save(EducationInstitution educationInstitution) {
        return educationInstitutionRepository.save(educationInstitution);
    }

    @Override
    public void delete(Integer id) {
        educationInstitutionRepository.deleteById(id);
    }

    @Override
    public List<EducationInstitution> findAllByAccreditation(Integer accreditation) {
        return educationInstitutionRepository.findAllByAccreditationOrderByIdDesc(accreditation);
    }

    @Override
    public List<EducationInstitution> findAllByNumberOfStudentsAndNumberOfUniversity(Integer numberOfStudents, Integer numberOfUniversity) {
        return educationInstitutionRepository.findAllByNumberOfStudentsAndNumberOfUniversity(numberOfStudents,numberOfUniversity);
    }

    @Override
    public List<EducationInstitution> findAllByAddressUniversity(String addressUniversity) {
        return educationInstitutionRepository.findAllByAddressUniversity(addressUniversity);
    }

    @Override
    public List<EducationInstitution> findAllByNumberOfStudentsBetween(Integer numberOfStudents, Integer numberOfStudents2) {
        return educationInstitutionRepository.findAllByNumberOfStudentsLessThanAndNumberOfStudentsGreaterThan(numberOfStudents, numberOfStudents2);
    }

}
