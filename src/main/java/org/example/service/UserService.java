package org.example.service;

import org.example.data.models.User;
import org.example.data.repository.UserRepository;
import org.example.exception.IncorrectEmailException;
import org.example.exception.IncorrectPasswordException;
import org.example.exception.InvalidEmailException;
import org.example.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User register(User user) throws UserFoundException {
        User existingUser= userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            user.setUserName(user.getUserName());
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            user.setRole(user.getRole());
            return userRepository.save(user);
        }
        throw new UserFoundException("User details already exists");
    }
    public User login(String email, String password) throws UserNotFoundException, IncorrectPasswordException {

        User user = userRepository.findByEmail(email);
        if(!user.getEmail().equals(email)){
            throw new IncorrectEmailException("Incorrect email");
        }
        if (!user.getPassword().equals(password)) {
            throw new IncorrectPasswordException("Incorrect password");
        }
        return user;
    }



    public User updateProfile(User user)  throws InvalidEmailException {
        userRepository.findByEmail(user.getEmail());
        user.setUserName(user.getUserName());
        user.setEmail(user.getEmail());
        userRepository.update(user);
        return user;
    }


}
