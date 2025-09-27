package com.icube.exercise.spring.boot.user;

import com.icube.exercise.spring.boot.notification.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        if (userRepository.trySave(user)) {
            notificationService.send("User registered!", user.email);
        } else {
            notificationService.send("You already have an account!", user.email);
        }
    }
}
