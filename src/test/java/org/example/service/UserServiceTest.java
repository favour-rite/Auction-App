package org.example.service;

import com.mongodb.client.MongoClient;
import org.example.data.models.User;
import org.example.data.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.example.data.enums.Gender.FEMALE;
import static org.example.data.enums.Gender.MALE;
import static org.example.data.enums.Role.ADMIN;
import static org.example.data.enums.Role.BUYER;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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
    public void testThatUserCanRegister() {
        User user = new User();
        user.setUserName(" Rachel Dennis");
        user.setPassword("babygirl123");
        user.setEmail("MoneyWise0@gmail.com");
        user.setRole(ADMIN);
        user.setGender(MALE);

         User user1 = userService.register(user);
        assertEquals("Rachel Dennis", user1.getUserName());
        assertEquals("MoneyWise0@gmail.com", user1.getEmail());
        assertEquals(MALE, user1.getGender());
        assertEquals(ADMIN, user1.getRole());
        assertEquals(1, userRepository.count());

    }
    @Test
    public void testThatUserCanLogin() {
        User user = userService.login("regina10@gmail.com", "happymood123");
        assertEquals("Precious Regina", user.getUserName());
        assertEquals("regina10@gmail.com", user.getEmail());
        assertEquals(MALE, user.getGender());
        assertEquals(ADMIN, user.getRole());
        assertEquals(1, userRepository.count());

    }
    @Test
    public void testThatProfileCanBeUpdated() {
        User user = new User();
        user.setUserName("Precious Regina");
        user.setPassword("happymood123");
        user.setEmail("regina10@gmail.com");
        user.setRole(BUYER);
        user.setGender(FEMALE);
        User user1 = userService.updateProfile(user);
        assertEquals("Precious Regina", user1.getUserName());
        assertEquals("regina10@gmail.com", user1.getEmail());
        assertEquals(FEMALE, user1.getGender());
        assertEquals(BUYER, user1.getRole());
        assertEquals(1, userRepository.count());

    }
}