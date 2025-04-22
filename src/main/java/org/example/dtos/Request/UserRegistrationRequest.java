package org.example.dtos.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.example.data.enums.Gender;
import org.example.data.enums.Role;

@Data
public class UserRegistrationRequest {

    private String UserName;
    private String email;
    private String password;
    private Gender gender;
    private Role role;



}
