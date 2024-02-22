package com.ainotes.backendainotes.config;

import com.ainotes.backendainotes.model.User;
import com.ainotes.backendainotes.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationRunnerConfig {

    @Bean
    public ApplicationRunner dataLoader(UserRepository userRepo) {
        String username = "Bartek";
        String login = "123";

        return args -> {
            if (userRepo.findUserByUsernameAndLogin(username, login) == null) {
                userRepo.save(new User("Bartek", "123", "123", "mail"));
            } else
                System.out.println("User already exists");
        };
    }
}
