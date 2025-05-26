package org.example.dtos.Request;

import lombok.Data;
import org.example.data.enums.Gender;
@Data
public class UserRequest {
    private String userName;
    private String password;
    private Gender gender;
    private String email;
}
