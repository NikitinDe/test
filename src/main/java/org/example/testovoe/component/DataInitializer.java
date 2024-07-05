package org.example.testovoe.component;

import lombok.RequiredArgsConstructor;
import org.example.testovoe.modelDto.Role;
import org.example.testovoe.modelDto.User;
import org.example.testovoe.repository.RoleRepository;
import org.example.testovoe.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;



    @Override
    public void run(String... args) throws Exception {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> roleRepository.save(new Role("ROLE_ADMIN")));

        Role frontendRole = roleRepository.findByName("ROLE_FRONTEND")
                .orElseGet(() -> roleRepository.save(new Role("ROLE_FRONTEND")));

        Role backendRole = roleRepository.findByName("ROLE_BACKEND")
                .orElseGet(() -> roleRepository.save(new Role("ROLE_BACKEND")));

        User admin = userRepository.findByUsername("admin")
                .orElseGet(() -> userRepository.save(new User("admin", "admin", Collections.singleton(adminRole))));

        User user1 = userRepository.findByUsername("user1")
                .orElseGet(() -> userRepository.save(new User("user1", "user1", Collections.singleton(frontendRole))));

        User user2 = userRepository.findByUsername("user2")
                .orElseGet(() -> userRepository.save(new User("user2", "user2", new HashSet<>(Arrays.asList(frontendRole, backendRole)))));

        User user3 = userRepository.findByUsername("user3")
                .orElseGet(() -> userRepository.save(new User("user3", "user3", Collections.singleton(backendRole))));
    }
}
