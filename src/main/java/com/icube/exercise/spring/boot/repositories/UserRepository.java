package com.icube.exercise.spring.boot.repositories;

import com.icube.exercise.spring.boot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
