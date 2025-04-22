package org.example.service;

import org.example.data.repository.PaymentRepository;
import org.example.data.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;

class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PaymentRepository paymentRepository;


    @AfterEach
    void tearDown() {
        paymentRepository.deleteAll();
    }
}