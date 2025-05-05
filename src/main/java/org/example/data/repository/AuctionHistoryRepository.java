package org.example.data.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionHistoryRepository extends MongoRepository<AuctionHistoryRepository, String> {
    void  deleteAll();


}
