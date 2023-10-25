package com.digitalholics.healthrecordandexpertiseservice.rest;

import com.digitalholics.healthrecordandexpertiseservice.domain.service.DiagnosisService;
import com.digitalholics.healthrecordandexpertiseservice.mapping.DiagnosisMapper;
import com.digitalholics.healthrecordandexpertiseservice.resource.DiagnosisResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/diagnoses", produces = "application/json")
@Tag(name = "Diagnoses", description = "Read and delete diagnoses")
public class DiagnosesController {

    private final DiagnosisService diagnosisService;

    private final DiagnosisMapper mapper;

    public DiagnosesController(DiagnosisService diagnosisService, DiagnosisMapper mapper) {
        this.diagnosisService = diagnosisService;
        this.mapper = mapper;
    }

}
