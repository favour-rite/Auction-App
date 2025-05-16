package org.example.Mapper;

import org.example.data.models.User;
import org.example.dtos.Request.UserLoginRequest;
import org.example.dtos.Response.UserLoginResponse;


public class UserLoginMapper {

    public static User mapToUser(UserLoginRequest userLoginRequest) {
        User user = new User();
        user.setEmail(userLoginRequest.getEmail());
        user.setPassword(userLoginRequest.getPassword());
        return user;
    }

    public static UserLoginResponse mapToUserResponse(String message) {
        UserLoginResponse response = new UserLoginResponse();
        response.setMessage(message);
        return response;
    }
}
