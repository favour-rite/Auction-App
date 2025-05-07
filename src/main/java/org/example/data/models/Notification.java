package org.example.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    private String NotificationId;
    private String message;
    private boolean read = false;
    private LocalDate createdAt;
    private LocalTime time;
    @DBRef
    private User user;

}
