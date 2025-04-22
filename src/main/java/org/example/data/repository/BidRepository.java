package org.example.data.repository;

import org.example.data.models.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BidRepository extends MongoRepository<Bid, String> {
    List<Bid> findByProductId(String productId);
    void save(Bid bid);

    Bid findById(String id);

    void update(Bid bid);

    void delete(Bid bid);
}
