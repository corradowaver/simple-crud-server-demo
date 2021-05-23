package com.molvaoffice.autoservice.db_layer.repository;

import com.molvaoffice.autoservice.domain.entity.MasterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MasterRepository extends CrudRepository<MasterEntity, Long> {

    List<MasterEntity> findAll();
}
