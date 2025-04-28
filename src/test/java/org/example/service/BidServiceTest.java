package org.example.service;

import org.example.BazaarBazaar;

import org.example.data.models.Bid;
import org.example.data.models.Product;
import org.example.data.repository.BidRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

@SpringBootTest(classes = BazaarBazaar.class)
class BidServiceTest {

    @Autowired
    private BidService bidService;
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private ProductService productService;

    @AfterEach
    void tearDown() {
        bidRepository.deleteAll();
    }

    @Test
    public void testThatBidPlacedForAnAuctionIsAchieved() {

        Product product = new Product();
        product.setProductName("Gucci Top");
        product.setCategory("Clothing");
        product.setDescription("Outdated Gucci Top");
        product.setStartingPrice(45.00);
        product.setAuctionStartTime(LocalTime.of(2, 4, 0));
        product.setAuctionEndTime(LocalTime.of(2, 4, 59));

        double bidAmount = 50.00;
        Bid bid = new Bid();
        bid.setTimeStamp(LocalTime.of(2, 5, 45));
        bid.setBidAmount(bidAmount);

        Bid bid1 = bidService.placeABidForAnAuctionBid("auctionId123", LocalTime.now(), 150.0);

        assertEquals(LocalTime.of(2, 5, 45), bid1.getTimeStamp());
        assertEquals(bidAmount, bid1.getBidAmount(), 0.01);
        assertEquals(bidAmount, product.getCurrentBidAmount(), 0.01);
    }
    @Test
    public void testThatBidCanBeUpdated(){
        Product product = new Product();
        product.setProductName("Gucci Top");
        product.setCurrentBidAmount(40.95);
        product.setCategory("Clothing");
        product.setDescription("Outdated Gucci Top");
        product.setStartingPrice(45.00);
        product.setAuctionStartTime(LocalTime.of(2, 4, 0));
        product.setAuctionEndTime(LocalTime.of(2, 4, 59));


        Bid bid = new Bid();
        bid.setTimeStamp(LocalTime.of(2, 4, 0));
        bid.setBidAmount(50.00);

        assertEquals(LocalTime.of(2, 5, 45), bid.getTimeStamp());
        assertEquals(50.00, bid.getBidAmount(), 0.01);
        assertEquals(40.00, product.getCurrentBidAmount(), 0.01);


    }

}