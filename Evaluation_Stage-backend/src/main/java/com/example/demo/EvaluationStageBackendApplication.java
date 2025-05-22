package com.example.demo;

import com.example.demo.model.Tuteur;
import com.example.demo.repositories.PersonneRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EvaluationStageBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvaluationStageBackendApplication.class, args);
    }
}