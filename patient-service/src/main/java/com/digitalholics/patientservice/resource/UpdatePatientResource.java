package com.digitalholics.patientservice.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePatientResource {

    private int age;

    private String medicalHistory;

    private String description;

    private String url;
}
