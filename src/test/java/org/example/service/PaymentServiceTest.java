package org.example.service;

import org.example.data.enums.PaymentStatus;
import org.example.data.models.Payment;
import org.example.data.repository.PaymentRepository;
import org.example.exception.PaymentAlreadyCancelledException;
import org.example.exception.PaymentAlreadyConfirmedException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PaymentServiceTest {


    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private BidService bidService;

    @AfterEach
    void tearDown() {
        paymentRepository.deleteAll();
    }
    @Test
    public void testThatUserCanMakePaymentForBiddedProduct() throws PaymentAlreadyConfirmedException {
        String userId = "user123";
        String productId = "Bucket456";

        Payment payment = new Payment();
        payment.setPaymentMethod("Credit Card");
        payment.setPaymentAmount(150.00);
        payment.setStatus(PaymentStatus.PENDING);
        payment.setPaymentDate(LocalDate.now());
        paymentRepository.save(payment);

        Payment confirmedPayment = paymentService.makePayment(userId, productId, payment);

        assertNotNull(confirmedPayment);
        assertEquals(userId, confirmedPayment.getUserId());
        assertEquals(productId, confirmedPayment.getProductId());
        assertEquals(PaymentStatus.CONFIRMED, confirmedPayment.getStatus());
    }

    @Test
    public void testThatPaymentIsConfirmedForAnAuctionThatWasBidded() throws PaymentAlreadyConfirmedException{
        String userId = "user123";
        String productId = "Bucket456";

        Payment payment = new Payment();
        payment.setPaymentMethod("Credit Card");
        payment.setPaymentDate(LocalDate.now());
        payment.setPaymentAmount(150.00);
        payment.setStatus(PaymentStatus.PAID);

        paymentRepository.save(payment);

        Payment savedPayment = paymentService.confirmPayment(userId,productId,payment);
        assertNotNull(savedPayment);
        assertEquals("Credit Card", savedPayment.getPaymentMethod());
        assertEquals(LocalDate.now(), savedPayment.getPaymentDate());
        assertEquals(payment.getPaymentAmount(), savedPayment.getPaymentAmount());
//        assertEquals(PaymentStatus.PAID, savedPayment.getStatus());
    }

    @Test
    public void testThatPaymentCanBeCancelledForAProductBidded() throws PaymentAlreadyCancelledException {
        Payment payment = new Payment();
        payment.setStatus(PaymentStatus.PENDING);
        paymentRepository.save(payment);

        Payment cancelledPayment = paymentService.cancelPayment(payment);
        assertEquals(PaymentStatus.CANCELLED, cancelledPayment.getStatus());
    }
    @Test
    public void testThatYouCanViewPaymentStatus() {
        Payment payment = new Payment();
        payment.setStatus(PaymentStatus.CANCELLED);
        PaymentStatus status = paymentService.viewPaymentStatus(payment);
        assertEquals(PaymentStatus.CANCELLED, status);
    }

}


