package com.example.testforclearsolutions.controller;

import com.example.testforclearsolutions.dao.UserDao;
import com.example.testforclearsolutions.model.User;
import com.example.testforclearsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        Date birthDate = user.getBirthDate();
        if (!isUserOldEnough(birthDate)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Create the user
        User createdUser = userService.createUser(user);

        // Return a response with the created user and a status code
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    private boolean isUserOldEnough(Date birthDate) {
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthDate);

        Calendar today = Calendar.getInstance();

        // Calculate the user's age
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        // Check if the user's birthday has occurred this year
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)
                || (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        // Check if the user is older than or equal to 18
        return age >= 18;

    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> updateAllFields(@PathVariable Long userId, @Valid @RequestBody User user) {
        User existingUser = userService.getUserById(userId);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        // Update all fields of the user based on the request body
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setBirthDate(user.getBirthDate());
        existingUser.setAddress(user.getAddress());

        // Save the updated user
        User updatedUser = userService.updateUser(userId, existingUser);

        // Return a response with the updated user and a status code
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        User existingUser = userService.getUserById(userId);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        // Delete the user
        userService.deleteUser(userId);

        // Return a response with a NO_CONTENT status code indicating successful deletion
        return ResponseEntity.noContent().build();
    }
}
