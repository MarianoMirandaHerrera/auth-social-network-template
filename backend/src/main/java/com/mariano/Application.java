package com.mariano;

import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mariano.user.Gender;
import com.mariano.user.User;
import com.mariano.user.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	    @Bean
    CommandLineRunner runner(
            UserRepository userRepository) {
        return args -> {
			Random random = new Random();
            String name = "John Pork";
            int age = random.nextInt(18, 99);
            Gender gender = age % 2 == 0 ? Gender.MALE : Gender.FEMALE;
            String email = name + age + random.nextInt(0,99) + "@gmail.com";
			String password = "root";
            User usr = new User(
                    name,
                    email,
                    password,
                    age,
                    gender);
            userRepository.save(usr);
            System.out.println(email);
        };
    }
}