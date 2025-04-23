package org.example.data.repository;

import org.example.data.models.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends MongoRepository<Bid, String> {
    List<Bid> findByProductId(String productId);
    void update(Bid bid);
    void delete(Bid bid);
}
