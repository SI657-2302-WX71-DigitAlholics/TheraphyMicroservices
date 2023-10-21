package com.digitalholics.patientservice.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientResource {

    private int age;

    private String medicalHistory;

    private String url;

    private String birthday;

    private String appointmentQuantity;
}
