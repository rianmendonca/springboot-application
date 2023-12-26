package com.project.workshop.config;

import com.project.workshop.entities.Order;
import com.project.workshop.entities.User;
import com.project.workshop.enums.OrderStatus;
import com.project.workshop.repositories.OrderRepository;
import com.project.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "José Campos", "josec@gmail.com", "912344321", "12345678");
        User u2 = new User(null, "Ana Beatriz", "anab@hotmail.com", "943211234", "87654321");

        Order o1 = new Order(null, Instant.parse("2023-10-26T12:50:18Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2023-08-13T08:20:08Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2023-05-11T06:03:01Z"), OrderStatus.CANCELED, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
