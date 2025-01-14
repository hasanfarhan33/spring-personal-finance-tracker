package com.example.spring_personal_finance_tracker.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.spring_personal_finance_tracker.model.User;
import com.example.spring_personal_finance_tracker.repository.UserRepository;

import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for initializing user data in the database.
 * This class defines Spring Beans and is used to pre-load some user data
 * into the UserRepository when the application starts.
 */
@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User farhan = new User(
                "hasanfarhan33", 
                "hasanfarhan33@gmail.com", 
                "Farhan@1998", 
                "Farhan", 
                "Hasan", 
                "USER");
            
            User admin = new User(
                "admin", 
                "admin@gmail.com", 
                "1234", 
                "Admin", 
                "Admin", 
                "ADMIN"); 
            
            User rory = new User("roryPlaysEldenRing", "rory@gmail.com", "Rory@2002", "Rory", "McDonnell", "USER");

            User michael = new User("michaelIsTall", "michael.guerin@gmail.com", "Michael@2000", "Michael", "Guerin", "USER"); 

            userRepository.saveAll(List.of(farhan, admin, rory, michael)); 
        };
    }

}
