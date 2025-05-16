package org.example.controller;
import org.example.Mapper.UserLoginMapper;
import org.example.Mapper.UserSignUpMapper;
import org.example.data.models.User;
import org.example.dtos.Request.UserLoginRequest;
import org.example.dtos.Request.UserSignUpRequest;

import org.example.dtos.Response.UserLoginResponse;
import org.example.dtos.Response.UserSignUpResponse;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/signUp")
        public ResponseEntity<UserSignUpResponse> signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
            User signedUpUser = userServiceImpl.signUp(userSignUpRequest);
            UserSignUpResponse userSignUpResponse = UserSignUpMapper.mapToUser(user);
            return ResponseEntity.ok(userSignUpResponse);
        }

        @PostMapping("/login")
        public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
            UserLoginResponse loggedInUser = userServiceImpl.login(userLoginRequest);
            UserLoginResponse userLoginResponse = UserLoginMapper.mapToUser(user);
            return ResponseEntity.ok( userLoginResponse);
        }

        @PutMapping("/update-profile")
        public ResponseEntity<User> updateProfile(@RequestBody User userRequest) {
            User updatedUser = userServiceImpl.updateProfile(userRequest);
            return ResponseEntity.ok(updatedUser);
        }


}
