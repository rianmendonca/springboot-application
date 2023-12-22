package com.project.workshop.config;

import com.project.workshop.entities.User;
import com.project.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "José Campos", "josec@gmail.com", "912344321", "12345678");
        User u2 = new User(null, "Ana Beatriz", "anab@hotmail.com", "943211234", "87654321");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}