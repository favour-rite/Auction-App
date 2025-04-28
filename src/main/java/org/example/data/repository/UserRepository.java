package org.example.data.repository;
import org.example.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String username);
    void update(User user);
    User findByID(String id);
    void deleteAll();
    User findByEmail(String email);
}

