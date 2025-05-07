package org.example.controller;

import org.example.data.models.User;
import org.example.dtos.Request.UserRegistrationRequest;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {


        @Autowired
        private UserService userService;

        @PostMapping("/registration")
        public User registration(@RequestBody UserRegistrationRequest userRegistrationRequest) {
            User user = new User();
            user.setUserName(userRegistrationRequest.getUserName());
            user.setEmail(userRegistrationRequest.getEmail());
            user.setPassword(userRegistrationRequest.getPassword());
            user.setGender(userRegistrationRequest.getGender());
//            user.setRole(userRegistrationRequest.getRole());
            return userService.register(user);
        }
        @PostMapping("/login")
        public ResponseEntity<User> login(@RequestBody User userRequest) {
            User loggedInUser = userService.login(userRequest);
            return ResponseEntity.ok(loggedInUser);
        }
        @PutMapping("/update-profile")
        public ResponseEntity<User> updateProfile(@RequestBody User userRequest) {
            User updatedUser = userService.updateProfile(userRequest);
            return ResponseEntity.ok(updatedUser);
        }


}
