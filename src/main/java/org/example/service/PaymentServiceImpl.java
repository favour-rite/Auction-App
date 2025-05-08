package org.example.service;

import org.example.data.enums.PaymentStatus;
import org.example.data.models.Payment;
import org.example.data.models.User;
import org.example.data.repository.PaymentRepository;
import org.example.data.repository.UserRepository;
import org.example.exception.PaymentAlreadyConfirmedException;
import org.example.exception.ProductNotFoundException;
import org.example.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentService {


    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserRepository userRepository;


    public Payment makePayment(String userId, String productId, Payment paymentDetails) throws PaymentAlreadyConfirmedException, UserNotFoundException, ProductNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        paymentRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        if (paymentDetails.getStatus() == PaymentStatus.CONFIRMED) {
            throw new PaymentAlreadyConfirmedException("Payment is already confirmed");
        }
        paymentDetails.setUserId(userId);
        paymentDetails.setProductId(productId);
        paymentDetails.setStatus(PaymentStatus.CONFIRMED);
        paymentDetails.setPaymentDate(LocalDate.now());
        return paymentRepository.save(paymentDetails);
    }

    public Payment confirmPayment(String userId, String productId, Payment payment) throws PaymentAlreadyConfirmedException, UserNotFoundException, ProductNotFoundException {
        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        paymentRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        if (payment.getStatus() == PaymentStatus.CONFIRMED) {
            throw new PaymentAlreadyConfirmedException("Payment is already confirmed");
        }
        payment.setStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
        return payment;
    }


    public Payment cancelPayment(String userId, String productId, Payment payment) throws PaymentAlreadyConfirmedException {
        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        paymentRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        if (payment.getStatus() == PaymentStatus.CONFIRMED) {
            throw new PaymentAlreadyConfirmedException("Cannot cancel a confirmed payment");
        }
        payment.setStatus(PaymentStatus.CANCELLED);
        paymentRepository.save(payment);
        return payment;
    }

    public PaymentStatus viewPaymentStatus(Payment payment) {

        return payment.getStatus();
    }

}


