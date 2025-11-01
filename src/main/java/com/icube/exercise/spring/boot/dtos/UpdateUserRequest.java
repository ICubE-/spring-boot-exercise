package com.icube.exercise.spring.boot.dtos;

import lombok.Data;

@Data
public class UpdateUserRequest {
    public String name;
    public String email;
}
