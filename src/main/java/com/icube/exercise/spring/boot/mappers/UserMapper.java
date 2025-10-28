package com.icube.exercise.spring.boot.mappers;

import com.icube.exercise.spring.boot.dtos.UserDto;
import com.icube.exercise.spring.boot.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
