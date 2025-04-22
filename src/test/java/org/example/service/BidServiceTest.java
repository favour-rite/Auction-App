package org.example.service;

import org.example.BazaarBazaar;

import org.example.data.repository.BidRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BazaarBazaar.class)
class BidServiceTest {

    @Autowired
    private BidService bidService;
    @Autowired
    private BidRepository bidRepository;

    @AfterEach
    void tearDown() {
        bidRepository.deleteAll();
    }

    @Test
    public void testThatBidPlacedForAnAuctionIsValidated(){


    }
}