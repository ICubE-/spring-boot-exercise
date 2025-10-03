package com.icube.exercise.spring.boot.repositories;

import com.icube.exercise.spring.boot.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
