package com.example.testforclearsolutions.service;

import com.example.testforclearsolutions.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class UserServiceImpl {
    private static Map<Long, User> users = new HashMap<>();
    private static Long index = 2L;

    static {
        User user1 = new User (1L, "Jonh@gmail.com", "John", "Johnson", LocalDate.of(2000, 5, 14), "Kyiv");
        User user2 = new User (2L, "Alice@gmail.com", "Alice", "Stockton", LocalDate.of(1994, 7, 4), "Kyiv");
    }

    public static User addUser (User user) {
        index += 1;
        user.setId(index);
        users.put(index, user);
        return user;
    }

    public static User updateUser (Long userId, User user) {
        user.setId(userId);
        users.put(userId, user);
        return user;
    }

    public static User deleteUser (Long userId) {
        return users.remove(userId);
    }
}