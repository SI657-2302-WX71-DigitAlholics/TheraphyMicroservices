package com.digitalholics.patientservice.api.rest;

import com.digitalholics.patientservice.domain.service.PatientService;
import com.digitalholics.patientservice.mapping.PatientMapper;
import com.digitalholics.patientservice.resource.CreatePatientResource;
import com.digitalholics.patientservice.resource.PatientResource;
import com.digitalholics.patientservice.resource.UpdatePatientResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/patients", produces = "application/json")
@Tag(name = "Patients", description = "Create, read, update and delete patients")
public class PatientsController {

    private final PatientService patientService;

    private final PatientMapper mapper;

    public PatientsController(PatientService patientService, PatientMapper mapper) {
        this.patientService = patientService;
        this.mapper = mapper;
    }

    @PostMapping("create-patient")
    public ResponseEntity<PatientResource> createPatient(@RequestBody CreatePatientResource resource) {
        return new ResponseEntity<>(mapper.toResource(patientService.create((resource))), HttpStatus.CREATED);
    }

    @DeleteMapping("{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer patientId) {
        return patientService.delete(patientId);
    }

    @GetMapping("allPatients")
    public Page<PatientResource> getAllPatients(Pageable pageable) {
        return mapper.modelListPage(patientService.getAll(), pageable);
    }

    @GetMapping("{patientId}")
    public PatientResource getPatientById(@PathVariable Integer patientId) {
        return mapper.toResource(patientService.getById(patientId));
    }

    @PutMapping("{patientId}")
    public PatientResource updatePatient(@PathVariable Integer patientId,
                                           @RequestBody UpdatePatientResource resource) {
        return mapper.toResource(patientService.update(patientId, mapper.toModel(resource)));
    }
}
