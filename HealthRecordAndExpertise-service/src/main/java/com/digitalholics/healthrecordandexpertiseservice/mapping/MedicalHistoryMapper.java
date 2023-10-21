package com.digitalholics.healthrecordandexpertiseservice.mapping;


import com.digitalholics.healthrecordandexpertiseservice.domain.model.entity.MedicalHistory;
import com.digitalholics.healthrecordandexpertiseservice.mapping.configuration.EnhancedModelMapper;


import com.digitalholics.healthrecordandexpertiseservice.resource.MedicalHistory.CreateMedicalHistoryResource;
import com.digitalholics.healthrecordandexpertiseservice.resource.MedicalHistory.MedicalHistoryResource;
import com.digitalholics.healthrecordandexpertiseservice.resource.MedicalHistory.UpdateMedicalHistoryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class MedicalHistoryMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public MedicalHistoryResource toResource(MedicalHistory model) {
        return mapper.map(model, MedicalHistoryResource.class);
    }

    public MedicalHistory toModel(CreateMedicalHistoryResource resource) {
        return mapper.map(resource, MedicalHistory.class);
    }

    public MedicalHistory toModel(UpdateMedicalHistoryResource resource) {
        return mapper.map(resource, MedicalHistory.class);
    }

    public Page<MedicalHistoryResource> modelListPage(List<MedicalHistory> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, MedicalHistoryResource.class), pageable, modelList.size());
    }
}
