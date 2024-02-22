package com.ainotes.backendainotes.config;

import com.ainotes.backendainotes.model.Role;
import com.ainotes.backendainotes.model.User;
import com.ainotes.backendainotes.repository.RoleRepository;
import com.ainotes.backendainotes.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ApplicationRunnerConfig {

    @Bean
    public ApplicationRunner dataLoader(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder) {
        return args -> {
            if (roleRepo.findByAuthority("ADMIN").isPresent()) return;

            Role adminRole = roleRepo.save(new Role("ADMIN"));
            roleRepo.save(new Role("USER"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            userRepo.save(new User("admin", "login",
                    encoder.encode("password"), roles));

        };
    }
}
