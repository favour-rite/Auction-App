package org.example.service;

import org.example.data.enums.PaymentStatus;
import org.example.data.models.Payment;
import org.example.exception.PaymentAlreadyConfirmedException;
import org.example.exception.ProductNotFoundException;
import org.example.exception.UserNotFoundException;

public interface PaymentService {
    Payment makePayment(String userId, String productId, Payment paymentDetails) throws PaymentAlreadyConfirmedException, UserNotFoundException, ProductNotFoundException;

    Payment confirmPayment(String userId, String productId, Payment payment) throws PaymentAlreadyConfirmedException, UserNotFoundException, ProductNotFoundException;

    Payment cancelPayment(String userId, String productId, Payment payment) throws PaymentAlreadyConfirmedException;

    PaymentStatus viewPaymentStatus(Payment payment);
}
