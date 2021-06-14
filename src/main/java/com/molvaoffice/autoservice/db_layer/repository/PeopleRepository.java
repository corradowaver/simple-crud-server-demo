package com.molvaoffice.autoservice.db_layer.repository;

import com.molvaoffice.autoservice.domain.entity.PeopleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository extends CrudRepository<PeopleEntity, Long> {

    List<PeopleEntity> findAll();
}
