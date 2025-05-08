package org.example.service;

import org.example.data.models.User;
import org.example.data.repository.UserRepository;
import org.example.exception.*;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Override
    public User signUp(User user) throws UserFoundException,UserAlreadyExist{
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExist("User already exists!");
        }
        User existingUser= userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            user.setUserName(user.getUserName());
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            user.setGender(user.getGender());
            return userRepository.save(user);
        }
        throw new UserFoundException("User details already exists");
    }

    @Override
    public User login(User user) throws UserNotFoundException, IncorrectPasswordException {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser == null) {
            throw new UserNotFoundException("User not found with email: " + user.getEmail());
        }
        if (!foundUser.getEmail().equals(user.getEmail())) {
            throw new IncorrectEmailException("Incorrect email");
        }
        if (!foundUser.getPassword().equals(user.getPassword())) {
            throw new IncorrectPasswordException("Incorrect password");
        }userRepository.save(foundUser);
        return foundUser;
    }
    @Override
    public User updateProfile(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser == null) {
            throw new UserNotFoundException("User not found with email: " + user.getEmail());
        }
            existingUser.setUserName(user.getUserName());
            existingUser.setGender(user.getGender());
//            existingUser.setRole(user.getRole());
            return userRepository.save(existingUser);
        }



}



