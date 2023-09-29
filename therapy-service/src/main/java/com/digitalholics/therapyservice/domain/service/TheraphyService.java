package com.digitalholics.therapyservice.domain.service;


import com.digitalholics.therapyservice.domain.model.entity.Theraphy;
import com.digitalholics.therapyservice.resource.CreateTheraphyResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TheraphyService {

    List<Theraphy> getAll();

    Page<Theraphy> getAll(Pageable pageable);

    Theraphy getById(Integer theraphyId);

    Theraphy create(CreateTheraphyResource theraphy);

    Theraphy update(Integer theraphyId, Theraphy request);

    ResponseEntity<?> delete(Integer theraphyId);

}
