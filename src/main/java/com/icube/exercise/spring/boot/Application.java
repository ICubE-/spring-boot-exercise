package com.icube.exercise.spring.boot;

import com.icube.exercise.spring.boot.entities.User;
import com.icube.exercise.spring.boot.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);
        var repository = context.getBean(UserRepository.class);

        var user = User.builder()
                .name("Jeho")
                .email("jeho.yeon@example.com")
                .password("password")
                .build();

        repository.save(user);

//        var user = repository.findById(1L).orElseThrow();
//        System.out.println(user.getEmail());

//        repository.findAll().forEach(user -> System.out.println(user.getEmail()));

//        repository.deleteAll();
	}

}
