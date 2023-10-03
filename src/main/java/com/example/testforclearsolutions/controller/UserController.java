package com.example.testforclearsolutions.controller;

import com.example.testforclearsolutions.model.User;
import com.example.testforclearsolutions.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return UserServiceImpl.addUser(user);
    }
    @DeleteMapping("/deleteUser/{userId}")
    public User deleteUser(@PathVariable Long user) {
        return UserServiceImpl.deleteUser(user);
    }
}
