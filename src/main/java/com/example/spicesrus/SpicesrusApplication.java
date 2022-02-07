package com.example.spicesrus;

import com.example.spicesrus.security.UDetails;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpicesrusApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpicesrusApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}