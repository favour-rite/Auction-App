package org.example.data.repository;

import org.example.data.models.Product;
import org.example.service.AuctionHistoryService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuctionHistoryRepository extends MongoRepository<AuctionHistoryRepository, String> {
    void save(AuctionHistoryService auctionHistory);

    List<AuctionHistoryService> findByProduct(Product product);

    void delectAll();
}
