package com.example.SpringProject.repository;

import com.example.SpringProject.model.EducationInstitution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class EducationInstitutionRepositoryTest {
    @Autowired
    private EducationInstitutionRepository educationInstitutionRepository;

    @BeforeEach
    public void init(){
        EducationInstitution educationInstitution = new EducationInstitution(1,"name",4,500,600,"UAd");
        educationInstitutionRepository.saveAndFlush(educationInstitution);
    }

//    @Test
//    public void toGet(){
//        EducationInstitution educationInstitution = educationInstitutionRepository.getOne(1);
//        assertEquals
//    }
}
