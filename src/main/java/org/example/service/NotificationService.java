package org.example.service;

import org.example.data.models.Notification;
import org.example.data.models.User;

import java.util.List;

public interface NotificationService {
    Notification sendNotification(User user, String message);

    Notification updateNotification(String newMessage);

    Notification deleteNotification(Notification notification);

    List<Notification> viewNotifications(User user);
}
