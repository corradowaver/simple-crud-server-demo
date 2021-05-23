package com.molvaoffice.autoservice.db_layer.repository;

import com.molvaoffice.autoservice.domain.entity.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {

    List<ServiceEntity> findAll();
}

