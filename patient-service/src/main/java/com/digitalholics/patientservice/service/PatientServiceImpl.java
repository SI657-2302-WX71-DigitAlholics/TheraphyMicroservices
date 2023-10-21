package com.digitalholics.patientservice.service;

import com.digitalholics.patientservice.domain.model.entity.Patient;
import com.digitalholics.patientservice.domain.persistence.PatientRepository;
import com.digitalholics.patientservice.domain.service.PatientService;
import com.digitalholics.patientservice.mapping.Exception.ResourceNotFoundException;
import com.digitalholics.patientservice.mapping.Exception.ResourceValidationException;
import com.digitalholics.patientservice.resource.CreatePatientResource;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PatientServiceImpl implements PatientService {

    private static final String ENTITY = "Patient";

    private final PatientRepository patientRepository;

    private final Validator validator;

    public PatientServiceImpl(PatientRepository patientRepository, Validator validator) {
        this.patientRepository = patientRepository;
        this.validator = validator;
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Page<Patient> getAll(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    public Patient getById(Integer patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, patientId));
    }

    @Override
    public Patient create(CreatePatientResource patientResource) {
        Set<ConstraintViolation<CreatePatientResource>> violations = validator.validate(patientResource);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Patient patient = new Patient();
        patient.setAge(patientResource.getAge());
        patient.setMedicalHistory(patientResource.getMedicalHistory());
        patient.setUrl(patientResource.getUrl());
        patient.setBirthday(patientResource.getBirthday());
        patient.setAppointmentQuantity(patientResource.getAppointmentQuantity());

        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Integer patientId, Patient request) {
        Set<ConstraintViolation<Patient>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return patientRepository.findById(patientId).map(patient ->
                patientRepository.save(
                        patient.withAge(request.getAge())
                                .withMedicalHistory(request.getMedicalHistory())
                                .withUrl(request.getUrl())
                                .withBirthday(request.getBirthday())
                                .withAppointmentQuantity(request.getAppointmentQuantity())
                )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, patientId));
    }

    @Override
    public ResponseEntity<?> delete(Integer patientId) {
        return patientRepository.findById(patientId)
                .map(patient -> {
                    patientRepository.delete(patient);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, patientId));
    }
}
