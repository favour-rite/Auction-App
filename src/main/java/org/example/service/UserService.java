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

    public User register(User user) throws UserNotFoundException {
        User existingUser= userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            user.setUserName(user.getUserName());
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            user.setRole(user.getRole());
            return userRepository.save(user);
        }
        throw new IllegalArgumentException("User details already exists");
    }
    public User login(String email, String password) throws UserNotFoundException, IncorrectPasswordException {
        User user = userRepository.findByID()
                .orElseThrow(() -> new  IllegalArgumentException ("User not found"));
        if (user == null) { throw new UserNotFoundException("User not found");}
        if(user.getEmail().equals(email) && user.getPassword().equals(password)) {throw new IncorrectEmailException("Incorrect  Email");}
        if (!user.getPassword().equals(password)) {throw new IncorrectPasswordException("Incorrect password");}
        return user;
    }


    public User updateProfile(User user)  throws InvalidEmailException {
        User oldUser = userRepository.findByUsername(user.getUserName());
        user.setUserName(user.getUserName());
        user.setEmail(user.getEmail());
        userRepository.update(user);
        return user;
    }


}
