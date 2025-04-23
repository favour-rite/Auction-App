package org.example.service;

import org.example.data.repository.AuctionHistoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProductServiceTest.class)
class AuctionHistoryServiceTest {


    @Autowired
    AuctionHistoryRepository auctionHistoryRepository;

    @AfterEach
    void tearDown() {
        auctionHistoryRepository.delectAll();
    }
}