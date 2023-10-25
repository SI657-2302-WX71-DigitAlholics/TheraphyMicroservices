package com.digitalholics.physiotherapistservice.resources;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class JobResource {
    private Integer id;
    private Integer physiotherapistId;
    private String position;
    private String Organization;
}
