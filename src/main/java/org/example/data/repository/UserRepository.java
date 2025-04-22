package org.example.data.repository;

import jakarta.validation.constraints.NotBlank;
import org.example.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String username);
    void update(User user);
    User findByID(String id);
    void deleteAll();
    User findByEmail(String email);
    User findByUsername(@NotBlank(message = "Username is required") String userName);
}
