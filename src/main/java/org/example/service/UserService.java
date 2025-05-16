package org.example.service;

import org.example.data.models.User;
import org.example.dtos.Request.UserSignUpRequest;
import org.example.exception.IncorrectPasswordException;
import org.example.exception.UserAlreadyExist;
import org.example.exception.UserFoundException;
import org.example.exception.UserNotFoundException;


public interface UserService {
    User signUp(UserSignUpRequest user) throws UserFoundException, UserAlreadyExist;

    User login(User user) throws UserNotFoundException, IncorrectPasswordException;

    User updateProfile(User user);
}
