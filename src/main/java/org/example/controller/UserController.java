package org.example.controller;

import org.example.data.models.User;
import org.example.dtos.Request.UserLoginRequest;
import org.example.dtos.Request.UserRequest;
import org.example.dtos.Request.UserSignUpRequest;
import org.example.dtos.Response.UserLoginResponse;
import org.example.dtos.Response.UserSignUpResponse;
import org.example.exception.UserAlreadyExistException;
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
    public ResponseEntity<UserSignUpResponse> signUp(@RequestBody UserSignUpRequest userSignUpRequest) throws UserAlreadyExistException {

        UserSignUpResponse userSignUpResponse = userServiceImpl.signUp(userSignUpRequest);
        return ResponseEntity.ok(userSignUpResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {

        UserLoginResponse userLoginResponse = userServiceImpl.login(userLoginRequest);
        return ResponseEntity.ok(userLoginResponse);
    }

//    @PutMapping("/update-profile")
//    public ResponseEntity<User> updateProfile(@RequestBody UserRequest userRequest) {
//        User updatedUser = userServiceImpl.updateProfile(userRequest);
//        return ResponseEntity.ok(updatedUser);
//    }
}
