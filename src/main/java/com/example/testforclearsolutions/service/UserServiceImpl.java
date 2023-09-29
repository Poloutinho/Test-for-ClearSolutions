package com.example.testforclearsolutions.service;

import com.example.testforclearsolutions.dao.UserDao;
import com.example.testforclearsolutions.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional // Ensure transactional behavior for user creation
    public User createUser(@NotNull @Valid User user) {
        // Perform age validation
        if (!isUserOldEnough(user.getBirthDate())) {
            throw new IllegalArgumentException("User must be at least 18 years old.");
        }

        // Save the user to the database
        return userDao.save(user);
    }

    @Override
    @Transactional // Ensure transactional behavior for user update
    public User updateUser(Long userId, @NotNull @Valid User user) {
        // Check if the user exists
        User existingUser = getUserById(userId);

        // Update user fields
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setBirthDate(user.getBirthDate());
        existingUser.setAddress(user.getAddress());

        // Save the updated user to the database
        return userDao.save(existingUser);
    }

    @Override
    @Transactional // Ensure transactional behavior for updating all user fields
    public User updateAllFields(Long userId, @NotNull @Valid User user) {
        // Check if the user exists
        User existingUser = getUserById(userId);

        // Update all user fields
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setBirthDate(user.getBirthDate());
        existingUser.setAddress(user.getAddress());

        // Save the updated user to the database
        return userDao.save(existingUser);
    }

    @Override
    @Transactional // Ensure transactional behavior for user deletion
    public void deleteUser(Long userId) {
        // Check if the user exists
        getUserById(userId);

        // Delete the user from the database
        userDao.deleteById(userId);
    }
    private boolean isUserOldEnough(Date birthDate) {
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthDate);

        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        // Check if the user's birthday has occurred this year
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)
                || (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        // Compare the user's age with 18
        return age >= 18;
    }

    // Helper method to get a user by ID and throw an exception if not found
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userDao.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        return optionalUser.get();
    }
}