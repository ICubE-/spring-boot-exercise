package com.icube.exercise.spring.boot;

import com.icube.exercise.spring.boot.notification.NotificationManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);
        var notificationManager = context.getBean(NotificationManager.class);
        notificationManager.sendNotification("Hello, this is a test message!");
	}

}
