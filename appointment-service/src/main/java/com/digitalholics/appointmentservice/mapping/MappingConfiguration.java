package com.digitalholics.appointmentservice.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("appointmentsMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public AppointmentMapper appointmentMapper() { return new AppointmentMapper();}
}
