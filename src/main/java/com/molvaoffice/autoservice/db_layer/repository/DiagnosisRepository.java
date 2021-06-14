package com.molvaoffice.autoservice.db_layer.repository;

import com.molvaoffice.autoservice.domain.entity.DiagnosisEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiagnosisRepository extends CrudRepository<DiagnosisEntity, Long> {

    List<DiagnosisEntity> findAll();
}
