package org.example.controller;
import org.example.data.models.User;
import org.example.dtos.Request.UserSignUpRequest;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {


        @Autowired
        private UserService userService;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/signUp")
        public ResponseEntity<User> signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
            User signedUpUser = userServiceImpl.signUp(user);
            return ResponseEntity.ok(userServiceImpl.signUp(signedUpUser));
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
