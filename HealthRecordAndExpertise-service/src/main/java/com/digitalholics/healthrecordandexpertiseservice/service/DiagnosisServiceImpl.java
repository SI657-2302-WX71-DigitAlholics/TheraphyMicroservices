package com.digitalholics.healthrecordandexpertiseservice.service;


import com.digitalholics.healthrecordandexpertiseservice.domain.model.entity.Diagnosis;
import com.digitalholics.healthrecordandexpertiseservice.domain.persistence.DiagnosisRepository;
import com.digitalholics.healthrecordandexpertiseservice.domain.service.DiagnosisService;
import com.digitalholics.healthrecordandexpertiseservice.mapping.Exception.ResourceNotFoundException;
import com.digitalholics.healthrecordandexpertiseservice.mapping.Exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {
    private static final String ENTITY = "Diagnosis";

    private final DiagnosisRepository diagnosisRepository;


    private final Validator validator;


    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository, Validator validator) {
        this.diagnosisRepository = diagnosisRepository;

        this.validator = validator;
    }




    @Override
    public Diagnosis create(Diagnosis diagnosisResource) {
        Set<ConstraintViolation<Diagnosis>> violations = validator.validate(diagnosisResource);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return diagnosisRepository.save(diagnosisResource);
    }

    @Override
    public ResponseEntity<?> delete(Integer diagnosisId) {
        return diagnosisRepository.findById(diagnosisId).map(diagnosis -> {
            diagnosisRepository.delete(diagnosis);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,diagnosisId));
    }
}
