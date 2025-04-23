package org.example.data.models;

import lombok.Data;
import org.example.data.enums.PaymentStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@Document(collection = "payments")
public class Payment {

    @Id
    private String id;
    private double currentBidAmount;
    private String paymentMethod;
    private LocalDate paymentDate;
    private Double paymentAmount;
    private String userId;
    private PaymentStatus status;
    private String productId;
}
