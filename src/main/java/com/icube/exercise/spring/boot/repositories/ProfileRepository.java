package com.icube.exercise.spring.boot.repositories;

import com.icube.exercise.spring.boot.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
