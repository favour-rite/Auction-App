package org.example.service;

import org.example.data.models.AuctionHistory;
import org.example.data.repository.AuctionHistoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AuctionHistoryServiceTest {


    @Autowired
    AuctionHistoryRepository auctionHistoryRepository;

    @AfterEach
    void tearDown() {
        auctionHistoryRepository.delectAll();
    }
}