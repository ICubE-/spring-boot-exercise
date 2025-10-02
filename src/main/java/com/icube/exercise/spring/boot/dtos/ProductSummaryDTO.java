package com.icube.exercise.spring.boot.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductSummaryDTO {
    private Long id;
    private String name;
}
