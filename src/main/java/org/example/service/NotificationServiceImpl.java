package org.example.service;

import org.example.data.models.Notification;
import org.example.data.models.User;
import org.example.data.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Service
public class NotificationServiceImpl implements NotificationService {


    private NotificationRepository notificationRepository;

    @Override
    public Notification sendNotification(User user, String message){
        Notification notification = new Notification();
        notification.setMessage("Your product has been sold!, Quickly contact the administrator for your share");
        notification.setCreatedAt(LocalDate.of(2012, 9, 8));
        notification.setTime(LocalTime.of(14, 30, 45));
        notificationRepository.save(notification);
        return notification;
    }

    @Override
    public Notification updateNotification(String newMessage) {
        Notification notification = new Notification();
        notification.setMessage(newMessage);
        notification.setCreatedAt(LocalDate.of(2012, 9, 9));
        notificationRepository.save(notification);
        return notification;
    }
    @Override
    public Notification deleteNotification(Notification notification) {
//        notificationRepository.delete();
        return notification ;
    }
    @Override
    public List<Notification> viewNotifications(User user) {
        return notificationRepository.findByUser(user);
    }
}
