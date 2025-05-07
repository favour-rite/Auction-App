package org.example.controller;

import org.example.data.models.User;
import org.example.dtos.Request.UserSignUpRequest;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {


        @Autowired
        private UserService userService;

        @PostMapping("/signUp")
        public User signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
            User user = new User();
            user.setUserName(userSignUpRequest.getUserName());
            user.setEmail(userSignUpRequest.getEmail());
            user.setPassword(userSignUpRequest.getPassword());
//            user.setGender(userSignUpRequest.getGender());
//            user.setRole(userRegistrationRequest.getRole());
            return userService.signUp(user);
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
