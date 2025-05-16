package org.example.dtos.Request;

import lombok.Data;
import org.example.data.enums.Gender;


@Data
public class UserSignUpRequest {

    private String UserName;
    private String email;
    private String password;
    private Gender gender;

}
