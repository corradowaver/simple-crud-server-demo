package com.molvaoffice.autoservice.db_layer.repository;

import com.molvaoffice.autoservice.domain.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository  extends CrudRepository<CarEntity, Long> {

    List<CarEntity> findAll();
}
