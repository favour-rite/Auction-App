package org.example.Mapper;

import org.example.data.models.User;
import org.example.dtos.Response.UserSignUpRequest;
import org.example.dtos.Response.UserSignUpResponse;

public class UserSignUpMapper {

    public static User mapToUser(UserSignUpRequest userSignUpRequest) {
        User user = new User();
        user.setUserName(userSignUpRequest.getUserName());
        user.setGender(userSignUpRequest.getGender());
        user.setEmail(userSignUpRequest.getEmail());
        user.setPassword(userSignUpRequest.getPassword());
        return user;
    }

    public static UserSignUpResponse mapToUserResponse(String message) {
        UserSignUpResponse response = new UserSignUpResponse();
        response.setMessage(message);
        response.setUserName(response.getUserName());
//        response.getOTP(response.getOTP());
        return response;
    }
}
