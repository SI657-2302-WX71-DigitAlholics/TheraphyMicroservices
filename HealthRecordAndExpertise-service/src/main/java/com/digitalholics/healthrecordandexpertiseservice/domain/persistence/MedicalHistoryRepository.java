package com.digitalholics.healthrecordandexpertiseservice.domain.persistence;



import com.digitalholics.healthrecordandexpertiseservice.domain.model.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import java.util.List;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Integer> {


}
