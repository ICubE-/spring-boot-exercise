package com.icube.exercise.spring.boot;

import com.icube.exercise.spring.boot.entities.Address;
import com.icube.exercise.spring.boot.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		var context = SpringApplication.run(Application.class, args);
        var user = User.builder()
                .name("Jeho")
                .email("jeho.yeon@example.com")
                .password("password")
                .build();
        var address = Address.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip("zip")
                .build();
        user.addAddress(address);
        System.out.println(user);
	}

}
