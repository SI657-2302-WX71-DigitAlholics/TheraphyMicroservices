package com.digitalholics.appointmentservice.domain.service;

import com.digitalholics.appointmentservice.domain.model.entity.Appointment;
import com.digitalholics.appointmentservice.resource.CreateAppointmentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAll();
    Page<Appointment> getAll(Pageable pageable);

    Appointment getById(Integer appointmentId);

    Appointment getAppointmentByTheraphyId(Integer theraphyId);

    Appointment create(CreateAppointmentResource appointment);

    Appointment update(Integer appointmentId, Appointment request);

    ResponseEntity<?> delete(Integer appointmentId);


//    List<Appointment> getAppointmentsByTheraphyByPatientId(Integer patientId);
//    List<Appointment> getAppointmentsByTheraphyByPhysiotherapistId(Integer physiotherapistId);

}
