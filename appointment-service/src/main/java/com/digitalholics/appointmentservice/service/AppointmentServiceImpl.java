package com.digitalholics.appointmentservice.service;


import com.digitalholics.appointmentservice.domain.model.entity.Appointment;
import com.digitalholics.appointmentservice.domain.model.entity.Theraphy;
import com.digitalholics.appointmentservice.domain.persistence.AppointmentRepository;
import com.digitalholics.appointmentservice.domain.service.AppointmentService;
import com.digitalholics.appointmentservice.mapping.Exception.ResourceNotFoundException;
import com.digitalholics.appointmentservice.mapping.Exception.ResourceValidationException;
import com.digitalholics.appointmentservice.resource.CreateAppointmentResource;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static final String ENTITY = "Appointment";

    private final AppointmentRepository appointmentRepository;


    private final Validator validator;

    public AppointmentServiceImpl(AppointmentRepository appointmenRepository, Validator validator) {
        this.appointmentRepository = appointmenRepository;
        this.validator = validator;
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Page<Appointment> getAll(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    @Override
    public Appointment getById(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public Appointment getAppointmentByTheraphyId(Integer theraphyId) {
        return appointmentRepository.findAppointmentByTheraphyId(theraphyId);
    }

    @Override
    public Appointment create(CreateAppointmentResource appointmentResource) {
        Set<ConstraintViolation<CreateAppointmentResource>> violations = validator.validate(appointmentResource);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Appointment appointmentWithTopic = appointmentRepository.findByTopic(appointmentResource.getTopic());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        if(appointmentWithTopic != null)
            throw new ResourceValidationException(ENTITY,
                    "A Appointment with the same topic already exists.");

        Appointment appointment = new Appointment();

        return appointmentRepository.save(appointment);

    }

    @Override
    public Appointment update(Integer appointmentId, Appointment request) {
        Set<ConstraintViolation<Appointment>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return appointmentRepository.findById(appointmentId).map(appointment ->
                        appointmentRepository.save(
                                appointment.withTopic(request.getTopic())
                                        .withDiagnosis(request.getDiagnosis())
                                        .withDone(request.getDone())
                                        .withPlace(request.getPlace())
                                        .withHour(request.getHour())
                                        .withDate(request.getDate())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public ResponseEntity<?> delete(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId).map( appointment -> {
            appointmentRepository.delete(appointment);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,appointmentId));
    }
}
