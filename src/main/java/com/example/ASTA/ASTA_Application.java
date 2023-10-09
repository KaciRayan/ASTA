package com.example.ASTA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ASTA_Application {

    public static void main(String[] args) {
        SpringApplication.run(ASTA_Application.class, args);
    }

    @GetMapping
    public List<String> getHello() {
        return List.of("Hello World", "Hello Might");
    }

}
