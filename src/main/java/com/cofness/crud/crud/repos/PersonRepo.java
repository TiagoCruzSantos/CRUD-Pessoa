package com.cofness.crud.crud.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cofness.crud.crud.entities.PersonEntity;

@Repository
public interface PersonRepo extends CrudRepository<PersonEntity, Long> {

}
