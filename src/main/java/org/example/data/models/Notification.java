package org.example.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    private String message;
    private boolean read = false;
    private Date createdAt = new Date();
    private String userId;

}
