package com.digitalholics.therapyservice.resource.Treatment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateTreatmentResource {

    private Integer id;

    private String videoUrl;


    private String duration;


    private String title;


    private String description;


    private String day;



    private Boolean viewed;

}
