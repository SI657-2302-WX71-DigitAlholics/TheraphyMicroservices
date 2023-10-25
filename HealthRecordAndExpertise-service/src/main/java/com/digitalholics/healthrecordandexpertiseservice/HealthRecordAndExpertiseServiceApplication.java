package com.digitalholics.healthrecordandexpertiseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class HealthRecordAndExpertiseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthRecordAndExpertiseServiceApplication.class, args);
    }

}
