package com.digitalholics.patientservice.resource.Therapy;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TherapyResource {
    private Integer id;
    private String theraphyName;
    private String appointmentQuantity;
    private String appointmentGap;
    private String startAt;
    private String finishAt;
}
