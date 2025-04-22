package org.example.data.repository;

import org.example.data.models.Notification;
import org.example.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<NotificationRepository, String> {
    void save(Notification notification);

    void update(Notification notification);

    void delete(Notification notification);

    List<Notification> findByUser(User user);

    void delectAll();
}
