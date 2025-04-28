package org.example.service;

import org.example.data.enums.PaymentStatus;
import org.example.data.models.Payment;
import org.example.data.repository.PaymentRepository;
import org.example.exception.PaymentAlreadyConfirmedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    @Autowired
    private PaymentRepository paymentRepository;

    public Payment confirmPayment(Payment payment) throws PaymentAlreadyConfirmedException {
        if (payment.getStatus() == PaymentStatus.CONFIRMED) {
            throw new PaymentAlreadyConfirmedException("Payment is already confirmed");
        }
        payment.setStatus(PaymentStatus.CONFIRMED);
//        paymentRepository.update(payment);
        return payment;
    }

    public Payment cancelPayment(Payment payment) throws PaymentAlreadyConfirmedException {
        if (payment.getStatus() == PaymentStatus.CONFIRMED) {
            throw new PaymentAlreadyConfirmedException("Cannot cancel a confirmed payment");
        }
        payment.setStatus(PaymentStatus.CANCELLED);
//        paymentRepository.update(payment);
        return payment;
    }

    public PaymentStatus viewPaymentStatus(Payment payment) {
        return payment.getStatus();
    }

}
