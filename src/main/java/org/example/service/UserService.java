package org.example.service;

import org.example.data.models.User;
import org.example.dtos.Request.UserLoginRequest;
import org.example.dtos.Request.UserSignUpRequest;
import org.example.dtos.Response.UserLoginResponse;
import org.example.dtos.Response.UserSignUpResponse;
import org.example.exception.InvalidPasswordException;
import org.example.exception.UserAlreadyExist;
import org.example.exception.UserAlreadyExistException;


public interface UserService {
    UserSignUpResponse signUp(UserSignUpRequest user) throws UserAlreadyExist, UserAlreadyExistException;


    UserLoginResponse login(UserLoginRequest userRequest) throws InvalidPasswordException;

    User updateProfile(UserSignUpRequest user);
}
