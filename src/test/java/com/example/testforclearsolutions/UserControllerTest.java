package com.example.testforclearsolutions;

//import com.example.testforclearsolutions.controller.UserController;
//import com.example.testforclearsolutions.model.User;
//import com.example.testforclearsolutions.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.util.AssertionErrors.assertEquals;
//import static org.testng.AssertJUnit.assertSame;
//
//@SpringBootTest
//class UserControllerTest {
//
//	@InjectMocks
//	private UserController userController;
//
//	@Mock
//	private UserService userService;
//
//	@Test
//	void createUserTest() {
//		// Create a user for testing
//		User user = new User();
//		user.setEmail("test@example.com");
//		user.setFirstName("John");
//		user.setLastName("Doe");
//		user.setBirthDate(new Date());
//
//		// Mock the userService's createUser method
//		when(userService.createUser(any(User.class))).thenReturn(user);
//
//		// Call the createUser endpoint
//		ResponseEntity<User> response = userController.createUser(user);
//
//		// Assert that the response is as expected
//		assertEquals("Expected status code: 201 CREATED", HttpStatus.CREATED.value(), response.getStatusCodeValue());
//		assertEquals(user, response.getBody());
//	}
//
//	@Test
//	void updateUserTest() {
//		// Create a user for testing
//		User user = new User();
//		user.setId(1L);
//		user.setEmail("test@example.com");
//		user.setFirstName("John");
//		user.setLastName("Doe");
//		user.setBirthDate(new Date());
//
//		// Mock the userService's updateUser method
//		when(userService.updateUser(eq(1L), any(User.class))).thenReturn(user);
//
//		// Call the updateUser endpoint
//		ResponseEntity<User> response = userController.updateUser(1L, user);
//
//		// Assert that the response is as expected
//		assertSame(response.getStatusCode(), HttpStatus.OK);
//		assertEquals(response.getBody(), user);
//	}
//
//	// Implement similar tests for other UserController endpoints
//}
