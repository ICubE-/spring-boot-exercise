package com.icube.exercise.spring.boot;

import com.icube.exercise.spring.boot.user.User;
import com.icube.exercise.spring.boot.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);
        var userService = context.getBean(UserService.class);
        userService.registerUser(new User(1, "jeho.yeon@example.com", "password", "Jeho"));
        userService.registerUser(new User(1, "jeho.yeon@example.com", "password", "Jeho"));
	}

}
