package com.molvaoffice.autoservice.db_layer.repository;

import com.molvaoffice.autoservice.domain.entity.WardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WardRepository extends CrudRepository<WardEntity, Long> {

    List<WardEntity> findAll();
}

