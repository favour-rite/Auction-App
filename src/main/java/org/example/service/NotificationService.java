package org.example.service;

import org.example.data.models.Notification;
import org.example.data.models.User;
import org.example.data.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification sendNotification(User user, String message) {
        Notification notification = new Notification();
        notificationRepository.save(notification);
        return notification;
    }

    public Notification updateNotification(Notification notification, String newMessage) {
        notification.setMessage(newMessage);
        notificationRepository.update(notification);
        return notification;
    }

    public Notification deleteNotification(Notification notification) {
        notificationRepository.delete(notification);
        return notification ;
    }

    public List<Notification> viewNotifications(User user) {
        return notificationRepository.findByUser(user);
    }
}
