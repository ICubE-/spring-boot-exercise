package com.icube.exercise.spring.boot.user;

public interface UserRepository {
    void save(User user);
    boolean trySave(User user);
}
