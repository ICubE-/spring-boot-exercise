package com.icube.exercise.spring.boot.repositories;

import com.icube.exercise.spring.boot.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
