package com.example.userservice.config;

import com.example.userservice.business.entities.User;
import com.example.userservice.ports.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InitialDatabase{
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            log.info("Preloading" + userRepository.save(new User("abc")));
            log.info("Preloading" + userRepository.save(new User("xyz")));
        };
    }
}
