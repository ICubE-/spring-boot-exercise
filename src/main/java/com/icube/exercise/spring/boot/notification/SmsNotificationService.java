package com.icube.exercise.spring.boot.notification;

import org.springframework.stereotype.Service;

@Service("sms")
public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("SMS");
        System.out.println(message);
    }
}
