package org.example.data.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.data.enums.AuctionStatus;
import org.example.data.enums.Gender;
import org.example.data.enums.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "users")
@Data
public class User {

    @Id
    private String ID;
    @NotBlank(message = "Username is required")
    private String userName;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password should be at least 6 characters")
    private String password;
    private Gender gender;
    private AuctionStatus status;
    private Role role;


}


