package org.example.data.models;

import lombok.Data;
import org.example.data.enums.PaymentStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "payments")
public class Payment {

    @Id
    private String id;
    private double currentBidAmount;
    private String paymentMethod;
    private Date paymentDate = new Date();
    private String userId;
    private PaymentStatus status;
    private String productId;
}
