package com.example.spicesrus;

import com.example.spicesrus.security.UDetails;
import com.example.spicesrus.security.UDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpicesrusApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpicesrusApplication.class, args);
    }


}
