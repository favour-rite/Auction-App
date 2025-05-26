package org.example.service;

import org.example.Mapper.UserSignUpMapper;
import org.example.data.models.User;
import org.example.data.repository.UserRepository;
import org.example.dtos.Request.UserLoginRequest;
import org.example.Mapper.UserLoginMapper;
import org.example.dtos.Request.UserSignUpRequest;
import org.example.dtos.Response.UserLoginResponse;
import org.example.dtos.Response.UserSignUpResponse;
import org.example.exception.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserLoginMapper UserLoginMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserLoginMapper userLoginMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.UserLoginMapper = userLoginMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserSignUpResponse signUp(UserSignUpRequest userSignUpRequest) throws UserAlreadyExistException {
        if (userRepository.existsByEmail(userSignUpRequest.getEmail())) {
            throw new UserAlreadyExistException("User already exists!");
        }
        User user = UserSignUpMapper.mapToUserRequest(userSignUpRequest);
        user.setPassword(passwordEncoder.encode(userSignUpRequest.getPassword()));
        userRepository.save(user);
        return UserSignUpMapper.mapToUserResponse("Account created successfully", user.getUserName());
    }


    @Override
    public UserLoginResponse login(UserLoginRequest userRequest) throws InvalidPasswordException {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByEmail(userRequest.getEmail()));
        if (existingUser.isEmpty()) {
            throw new UserNotFoundException("User not found with email: " + userRequest.getEmail());
        }
        User user = existingUser.get();
        if (!passwordEncoder.matches(userRequest.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        return UserLoginMapper.mapToUserResponse("User logged in successfully");
    }

    @Override
    public User updateProfile(UserSignUpRequest user) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser == null) {
            throw new UserNotFoundException("User not found with email: " + user.getEmail());
        }
            existingUser.setUserName(user.getUserName());
            return userRepository.save(existingUser);
        }




}



