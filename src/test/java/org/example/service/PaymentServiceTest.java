package org.example.service;

import org.example.data.enums.PaymentStatus;
import org.example.data.models.Payment;
import org.example.data.repository.PaymentRepository;
import org.example.exception.PaymentAlreadyConfirmedException;
import org.example.exception.PaymentIsCancelledException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.*;

@SpringBootTest
class PaymentServiceTest {


    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentService paymentService;

    @AfterEach
    void tearDown() {
        paymentRepository.deleteAll();
    }

    @Test
    public void testThatPaymentCanBeMadeForAnAuctionThatWasBidded() {
        Payment payment = new Payment();
        payment.setPaymentMethod("Credit Card");
        payment.setPaymentDate(LocalDate.now());
        payment.setPaymentAmount(70.00);
        payment.setStatus(PaymentStatus.PAID);

        paymentRepository.save(payment);

        Payment savedPayment = paymentRepository.findById(payment.getId()).orElse(null);
        assertNotNull(savedPayment);
        assertEquals("Credit Card", savedPayment.getPaymentMethod());
        assertEquals(LocalDate.now(), savedPayment.getPaymentDate());
        assertEquals(payment.getPaymentAmount(), savedPayment.getPaymentAmount());
        assertEquals(PaymentStatus.PAID, savedPayment.getStatus());
    }











//
//    @Test
//    public void testThatPaymentCanBeCancelled(){
//        Payment payment = new Payment();
//        payment.setStatus(PaymentStatus.CANCELLED);
//        paymentRepository.save(payment);
//
//    }
//    @Test
//    public void testConfirmPaymentWhenPendingShouldSetStatusToConfirmed() throws PaymentAlreadyConfirmedException {
//        Payment payment = new Payment();
//        payment.setStatus(PaymentStatus.PENDING);
//        Payment result = paymentService.confirmPayment(payment);
//        assertEquals(PaymentStatus.CONFIRMED, result.getStatus());
//    }
//
//    @Test
//    public void testConfirmPaymentWhenAlreadyConfirmedShouldThrowException() {
//        Payment payment = new Payment();
//        payment.setStatus(PaymentStatus.CONFIRMED);
//        assertThrows(PaymentAlreadyConfirmedException.class, () -> {
//            paymentService.confirmPayment(payment);
//        });
//    }
//
//    @Test
//    public void testThatPaymentCanBeCancelled_whenPending_ItShouldSetStatusToCancelled() throws PaymentIsCancelledException {
//        Payment payment = new Payment();
//        payment.setStatus(PaymentStatus.PENDING);
//        Payment result = paymentService.cancelPayment(payment);
//        assertEquals(PaymentStatus.CANCELLED, result.getStatus());
//    }
//
//    @Test
//    public void testThatPaymentCanBeCancelled_whenAlreadyConfirmed_shouldThrowException() {
//        Payment payment = new Payment();
//        payment.setStatus(PaymentStatus.CONFIRMED);
//        assertThrows(PaymentAlreadyConfirmedException.class, () -> {
//            paymentService.cancelPayment(payment);
//        });
//    }
//
//    @Test
//    public void testThatYouCanViewPaymentStatus_WhenReturnedToCurrentStatus() {
//        Payment payment = new Payment();
//        payment.setStatus(PaymentStatus.CANCELLED);
//        PaymentStatus status = paymentService.viewPaymentStatus(payment);
//        assertEquals(PaymentStatus.CANCELLED, status);
//    }
//}
//
//
}