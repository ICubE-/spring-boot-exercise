package com.icube.exercise.spring.boot.repositories;

import com.icube.exercise.spring.boot.entities.Category;
import com.icube.exercise.spring.boot.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaRepository {
    List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice, Category category);
}
