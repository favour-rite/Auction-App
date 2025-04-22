package org.example.data.repository;

import org.example.data.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {

    void save(Payment payment);

    void update(Payment payment);
}
