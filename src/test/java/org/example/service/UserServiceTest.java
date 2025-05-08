package org.example.service;

import org.example.data.models.User;
import org.example.data.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.example.data.enums.Gender.MALE;
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
    public void testThatUserCanRegister() {
        User user = new User();
        user.setUserName("Rachel Dennis");
        user.setPassword("babygirl123");
        user.setEmail("MoneyWise0@gmail.com");
        user.setGender(MALE);

        User registeredUser = userService.signUp(user);
        assertEquals("Rachel Dennis", registeredUser.getUserName());
        assertEquals("MoneyWise0@gmail.com", registeredUser.getEmail());
        assertEquals(MALE, registeredUser.getGender());
        assertEquals(1, userRepository.count());

    }
    @Test
    void testThatUserCanLogin() {
        User user = new User();
        user.setEmail("MoneyWise0@gmail.com");
        user.setPassword("babygirl123");
        userRepository.save(user);

        User loggedInUser = userService.login(user);
        assertNotNull(user);
        assertEquals("MoneyWise0@gmail.com", loggedInUser.getEmail());

    }
//    @Test
//    void testThatProfileCanBeUpdated() {
//        User user = new User();
//        user.setUserName("Rachel Dennis");
//        user.setEmail("MoneyWise0@gmail.com");
//        user.setPassword("babygirl123");
//        userRepository.save(user);
//        User updatingProfile = userService.updateProfile(user);
//
//        User updatedUser = userRepository.findByEmail("regina10@gmail.com");
//        assertNotNull(updatedUser);
//        assertEquals("rachel dennis",updatedUser.getUserName());
//        assertEquals("MoneyWise0@gmail.com",updatedUser.getEmail());
//
//    }


}