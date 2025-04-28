package org.example.service;

import org.example.data.enums.Gender;
import org.example.data.enums.Role;
import org.example.data.models.User;
import org.example.data.repository.UserRepository;
import org.example.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User register(User user) throws UserFoundException,UserAlreadyExist{
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExist("User already exists!");
        }
        User existingUser= userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            user.setUserName("Precious Regina");
            user.setEmail("regina10@gmail.com");
            user.setPassword("happymood123");
            user.setRole(Role.SELLER);
            user.setGender(Gender.FEMALE);
            return userRepository.save(user);
        }
        throw new UserFoundException("User details already exists");
    }

//    public User login(String email, String password) throws UserNotFoundException, IncorrectPasswordException {
//        User user = userRepository.findByEmail();
//        if (user == null) {throw new UserNotFoundException("User not found with email: ");
//        }if (!user.getEmail().equals(email)) {throw new IncorrectEmailException("Incorrect email");
//        }if (!user.getPassword().equals(password)) {throw new IncorrectPasswordException("Incorrect password");}
//        return user;
//    }
    public User login(User user) throws UserNotFoundException, IncorrectPasswordException {
        if (user == null) {
            throw new UserNotFoundException("User not found with email: ");
        }

        return user;
    }

    public User updateProfile(User user)  throws InvalidEmailException {
        userRepository.findByEmail();
        user.setUserName(user.getUserName());
        user.setEmail(user.getEmail());
        userRepository.save(user);
        return user;
    }


}
