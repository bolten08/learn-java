package com.learn.java;

import com.learn.java.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApplication implements CommandLineRunner {
    @Autowired
    ImageService imageService;

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        imageService.init();
    }
}
