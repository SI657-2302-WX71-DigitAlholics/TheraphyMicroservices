package com.digitalholics.physiotherapistservice.domain.persistence;

import com.digitalholics.physiotherapistservice.domain.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificationRepository extends JpaRepository<Certification,Integer> {

    Optional<Certification> findById(Integer certificationId);

}
