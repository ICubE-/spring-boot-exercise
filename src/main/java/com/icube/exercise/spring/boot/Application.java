package com.icube.exercise.spring.boot;

import com.icube.exercise.spring.boot.entities.User;
import com.icube.exercise.spring.boot.repositories.UserRepository;
import com.icube.exercise.spring.boot.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);
        var service = context.getBean(UserService.class);

        service.showRelatedEntities();
	}

}
