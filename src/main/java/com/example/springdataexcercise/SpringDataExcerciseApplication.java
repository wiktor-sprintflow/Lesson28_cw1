package com.example.springdataexcercise;

import com.example.springdataexcercise.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
public class SpringDataExcerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataExcerciseApplication.class, args);
    }
}
