package com.icube.exercise.spring.boot.user;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final HashMap<String,User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.email, user);
    }

    @Override
    public boolean trySave(User user) {
        return users.putIfAbsent(user.email,user) == null;
    }
}
