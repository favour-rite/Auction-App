package org.example.service;

import org.example.data.enums.PaymentStatus;
import org.example.data.models.Payment;
import org.example.data.models.Product;
import org.example.data.models.User;
import org.example.data.repository.PaymentRepository;
import org.example.data.repository.UserRepository;
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
    private PaymentServiceImpl paymentService;
    @Autowired
    private BidService bidService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        paymentRepository.deleteAll();
    }
    @Test
    public void testThatUserCanMakePaymentForBiddedProduct() throws PaymentAlreadyConfirmedException {
        User user = new User();
        user.setEmail("email@email.com");
        user.setPassword("password");
        user.setUserName("username");
        userRepository.save(user);

        Product product = new Product();
        product.setProductName("productName");
        product.setCategory("category");
        product.setDescription("description");

        Payment payment = new Payment();
        payment.setPaymentMethod("Credit Card");
        payment.setPaymentAmount(150.00);
        payment.setStatus(PaymentStatus.PENDING);
        payment.setPaymentDate(LocalDate.now());
        paymentRepository.save(payment);

   //     Payment confirmedPayment = paymentService.makePayment(user, product, payment);

//        assertNotNull(confirmedPayment);
//        assertEquals(user, confirmedPayment.getUserId());
//        assertEquals(product, confirmedPayment.getProductId());
//        assertEquals(PaymentStatus.CONFIRMED, confirmedPayment.getStatus());
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
    }

    @Test
    public void testThatPaymentCanBeCancelledForAProductBidded() throws PaymentAlreadyCancelledException {
        String userId = "user123";
        String productId = "Bucket456";

        Payment payment = new Payment();
        payment.setStatus(PaymentStatus.PENDING);
        paymentRepository.save(payment);

        Payment cancelledPayment = paymentService.cancelPayment(userId,productId,payment);
        assertNotNull(cancelledPayment);
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


