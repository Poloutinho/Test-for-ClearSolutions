package com.example.testforclearsolutions.config;

import com.example.testforclearsolutions.model.User;
import com.example.testforclearsolutions.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void inject() {
        Optional<User> byEmailVlad = userRepository.findByEmail("manager@com.ua");
        if (byEmailVlad.isEmpty()) {
            User manager1 = User.builder()
                    .email("manager@com.ua")
                    .firstName("Vlad")
                    .lastName("Docker")
                    .build();
            userRepository.save(manager1);

            Optional<User> byEmailPavlo = userRepository.findByEmail("manager2@com.ua");
            if (byEmailPavlo.isEmpty()) {
                User manager2 = User.builder()
                        .email("manager2@com.ua")
                        .firstName("Pavlo")
                        .lastName("Swagger")
                        .build();
                userRepository.save(manager2);
            }
        }
    }
}

