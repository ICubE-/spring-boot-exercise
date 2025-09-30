package com.icube.exercise.spring.boot.repositories;

import com.icube.exercise.spring.boot.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
