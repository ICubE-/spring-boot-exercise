package com.icube.exercise.spring.boot.repositories;

import com.icube.exercise.spring.boot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
