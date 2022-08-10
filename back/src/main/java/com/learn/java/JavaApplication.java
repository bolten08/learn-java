package com.learn.java;

import com.learn.java.repository.UserRepository;
import com.learn.java.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApplication implements CommandLineRunner {
    @Autowired
    DbService dbService;
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        dbService.connect("jdbc:mysql://localhost:3306/learn_java_db", "root", "root");
        userRepository.createTable();
    }
}
