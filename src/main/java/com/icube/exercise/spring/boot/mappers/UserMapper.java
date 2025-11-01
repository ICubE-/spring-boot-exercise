package com.icube.exercise.spring.boot.mappers;

import com.icube.exercise.spring.boot.dtos.RegisterUserRequest;
import com.icube.exercise.spring.boot.dtos.UpdateUserRequest;
import com.icube.exercise.spring.boot.dtos.UserDto;
import com.icube.exercise.spring.boot.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
