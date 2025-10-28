package com.icube.exercise.spring.boot.mappers;

import com.icube.exercise.spring.boot.dtos.ProductDto;
import com.icube.exercise.spring.boot.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);
}
