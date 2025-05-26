package org.example.service;

import org.example.data.enums.Gender;
import org.example.data.repository.UserRepository;
import org.example.dtos.Request.UserLoginRequest;
import org.example.dtos.Request.UserRequest;
import org.example.dtos.Request.UserSignUpRequest;
import org.example.dtos.Response.UserLoginResponse;
import org.example.dtos.Response.UserResponse;
import org.example.dtos.Response.UserSignUpResponse;
import org.example.exception.UserAlreadyExistException;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = UserServiceTest.class)
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void testThatUserCanRegister() throws UserAlreadyExistException {
        UserSignUpRequest userSignUpRequest = new UserSignUpRequest();
        userSignUpRequest.setUserName("Rachel Dennis");
        userSignUpRequest.setPassword("password123");
        userSignUpRequest.setEmail("MoneyWise0@gmail.com");
        userSignUpRequest.setGender(Gender.MALE);

        UserSignUpResponse response = userService.signUp(userSignUpRequest);
        assertNotNull(userSignUpRequest);
        assertEquals("Account created successfully You can now place bid,buy , sell product", response.getMessage());
        assertEquals("Rachel Dennis", response.getUserName());
        assertEquals(1, userRepository.count());
    }
    @Test
    public void testThatUserAlreadyExistsExceptionIsThrown() throws UserAlreadyExistException {
        UserSignUpRequest userSignUpRequest = new UserSignUpRequest();
        userSignUpRequest.setUserName("Rachel Dennis");
        userSignUpRequest.setPassword("password123");
        userSignUpRequest.setEmail("MoneyWise0@gmail.com");
        userSignUpRequest.setGender(Gender.MALE);

        userService.signUp(userSignUpRequest);

        assertThrows(UserAlreadyExistException.class, () -> {
            userService.signUp(userSignUpRequest);
        });
    }

    @Test
    void testThatUserCanLogin() {
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setPassword("password123");
        userLoginRequest.setEmail("MoneyWise0@gmail.com");

        UserLoginResponse response = userService.login(userLoginRequest);


        assertNotNull(response);
        assertEquals("User logged in successfully", response.getMessage());
        assertEquals("MoneyWise0@gmail.com", userLoginRequest.getEmail());
    }

//    @Test
//    void testThatProfileCanBeUpdated() {
//        UserRequest userRequest = new UserRequest();
//        userRequest.setUserName("Rachel Dennis");
//        userRequest.setEmail("MoneyWise0@gmail.com");
//        userRequest.setPassword("babygirl123");
//
//        userRepository.findByEmail("regina10@gmail.com");
//        UserResponse updatingProfileResponse = userService.updateProfile(userRequest);
//
////        assertNotNull(updatingProfileResponse);
//        assertEquals("rachel dennis",updatingProfileResponse.getUserName());
//        assertEquals("MoneyWise0@gmail.com",updatingProfileResponse.getEmail());
//        assertEquals("Your credentials has been updated",updatingProfileResponse.getMessage());
//
//    }


}