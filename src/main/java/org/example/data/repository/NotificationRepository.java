package org.example.data.repository;

import org.example.data.models.Notification;
import org.example.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<NotificationRepository, String> {
    void save(Notification notification);
    void deleteById(String id);

    @Query("{ 'user' : ?0 }")
    List<Notification> findByUser(User user);
    void deleteAll();
}
