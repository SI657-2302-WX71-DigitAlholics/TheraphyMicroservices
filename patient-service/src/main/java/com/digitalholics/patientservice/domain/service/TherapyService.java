package com.digitalholics.patientservice.domain.service;

import com.digitalholics.patientservice.domain.model.entity.Therapy;
import com.digitalholics.patientservice.resource.Therapy.CreateTherapyResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TherapyService {

    List<Therapy> getAll();

    Page<Therapy> getAll(Pageable pageable);

    Therapy getById(Integer therapyId);

    Therapy create(CreateTherapyResource therapyResource);

    List<Therapy> getTherapyByPatientId(Integer patientId);

    Therapy update(Integer therapyId, Therapy request);

    ResponseEntity<?> delete(Integer therapyId);
}
