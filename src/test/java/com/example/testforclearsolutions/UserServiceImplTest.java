package com.example.testforclearsolutions;

//import com.example.testforclearsolutions.dao.UserDao;
//import com.example.testforclearsolutions.model.User;
//import com.example.testforclearsolutions.service.UserServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//
//import static org.mockito.Mockito.*;
//import static org.testng.AssertJUnit.assertEquals;
//
//@SpringBootTest
//class UserServiceImplTest {
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @Mock
//    private UserDao userDao;
//
//    @Test
//    void createUserTest() {
//        // Create a user for testing
//        User user = new User();
//        user.setEmail("test@example.com");
//        user.setFirstName("John");
//        user.setLastName("Doe");
//        user.setBirthDate(new Date());
//
//        // Mock the userRepository's save method
//        when(userDao.save(any(User.class))).thenReturn(user);
//
//        // Call the createUser method
//        User createdUser = userService.createUser(user);
//
//        // Assert that the createdUser is as expected
//        assertEquals(createdUser, user);
//    }
//
//    @Test
//    void updateUserTest() {
//        // Create a user for testing
//        User existingUser = new User();
//        existingUser.setId(1);
//        existingUser.setEmail("test@example.com");
//        existingUser.setFirstName("John");
//        existingUser.setLastName("Doe");
//        existingUser.setBirthDate(new Date());
//
//        User updatedUser = new User();
//        updatedUser.setFirstName("Updated John");
//
//        // Mock the userRepository's findById and save methods
//        when(userDao.findById(1L)).thenReturn(java.util.Optional.of(existingUser));
//        when(userDao.save(any(User.class))).thenReturn(updatedUser);
//
//        // Call the updateUser method
//        User result = userService.updateUser(1L, updatedUser);
//
//        // Assert that the result is as expected
//        assertEquals(result.getFirstName(), "Updated John");
//    }
//
//    // Implement similar tests for other UserService methods
//}
