package com.example.testforclearsolutions.service;

import com.example.testforclearsolutions.model.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(Long userId, User user);
    User updateAllFields(Long userId, User user);
    void deleteUser(Long userId);

    User getUserById(Long userId);
}