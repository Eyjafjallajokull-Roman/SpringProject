package com.example.SpringProject.service;

import com.example.SpringProject.model.EducationInstitution;
import com.example.SpringProject.repository.EducationInstitutionRepository;
import com.example.SpringProject.service.serviceImpl.EducationInstitutionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EducationInstitutionServiceTest {
    @Mock
    private EducationInstitutionRepository educationInstitutionRepository;

    @InjectMocks //те що саме що зробити об'єкт через конструктор і передали туда параметри
    private EducationInstitutionServiceImpl educationInstitutionService;

    @Test
    @DisplayName("Get all institution")
    public void testFindAll(){
        when(educationInstitutionRepository.findAll(any(Sort.class))).thenReturn(Collections.singletonList(new EducationInstitution()));
        List<EducationInstitution> educationInstitutionList = educationInstitutionService.findAll();
        assertFalse(educationInstitutionList.isEmpty());


    }

    @Test
    @DisplayName("Get one institution")
    public void testFindOne(){
        when(educationInstitutionRepository.findOne(any()))
                .thenReturn(Optional.of(new EducationInstitution("name", 4, 100, 200, "UAD")));
        EducationInstitution educationInstitution = educationInstitutionService.findOne(2);
        assertEquals("name", educationInstitution.getName());


    }





}
