package org.example.data.repository;
import jakarta.validation.constraints.Email;
import org.example.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    void deleteAll();
    User findByEmail(@Email(message = "Email should be valid") String email);
}

