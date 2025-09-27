package com.icube.exercise.spring.boot.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {
    @Value("${notification.email.host}")
    private String host;

    @Value("${notification.email.port:587}")
    private String port;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Sending email to " + recipientEmail);
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println(message);
    }
}
