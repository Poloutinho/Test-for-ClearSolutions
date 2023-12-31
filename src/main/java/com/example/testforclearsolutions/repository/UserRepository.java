package com.example.testforclearsolutions.repository;

import com.example.testforclearsolutions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFirstName(String firstName);

    Optional<User> findByEmail(String email);
}
