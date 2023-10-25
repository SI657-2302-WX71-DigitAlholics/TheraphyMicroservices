package com.digitalholics.patientservice.domain.persistence;

import com.digitalholics.patientservice.domain.model.entity.Therapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TherapyRepository extends JpaRepository<Therapy, Integer> {
    List<Therapy> findTherapyByPatientId(Integer patientId);
}
