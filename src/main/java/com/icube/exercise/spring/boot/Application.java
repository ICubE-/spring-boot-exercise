package com.icube.exercise.spring.boot;

import com.icube.exercise.spring.boot.entities.Address;
import com.icube.exercise.spring.boot.entities.Profile;
import com.icube.exercise.spring.boot.entities.Tag;
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
        var profile = Profile.builder()
                .bio("bio")
                .build();
        user.setProfile(profile);
        profile.setUser(user);
        System.out.println(user);
	}

}
