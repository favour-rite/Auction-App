package org.example.service;

import org.example.data.enums.Role;
import org.example.data.models.Notification;
import org.example.data.models.User;
import org.example.data.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification sendNotification(User user, String message){
        Notification notification = new Notification();
        notification.setRole(Role.SELLER);
        notification.setMessage("Your product has been sold!, Quickly contact the administrator for your share");
        notification.setCreatedAt(LocalDate.of(2012, 9, 8));
        notification.setTime(LocalTime.of(14, 30, 45));
        notificationRepository.save(notification);
        return notification;
    }

    public Notification updateNotification(String newMessage) {
        Notification notification = new Notification();
        notification.setMessage(newMessage);
        notification.setRole(Role.SELLER);
        notification.setCreatedAt(LocalDate.of(2012, 9, 9));
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
