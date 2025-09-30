package com.icube.exercise.spring.boot.repositories;

import com.icube.exercise.spring.boot.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
