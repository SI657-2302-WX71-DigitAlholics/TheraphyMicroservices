package com.digitalholics.healthrecordandexpertiseservice.domain.service;


import com.digitalholics.healthrecordandexpertiseservice.domain.model.entity.Diagnosis;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DiagnosisService {


    Diagnosis create(Diagnosis diagnosis);
    ResponseEntity<?> delete(Integer patientId);
}
