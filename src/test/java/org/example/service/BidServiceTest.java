package org.example.service;

import org.example.BazaarBazaar;
import org.example.data.enums.Gender;
import org.example.data.models.Bid;
import org.example.data.models.Product;
import org.example.data.models.User;
import org.example.data.repository.BidRepository;
import org.example.data.repository.ProductRepository;
import org.example.data.repository.UserRepository;
import org.example.exception.BidTooLowException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest(classes = BazaarBazaar.class)
class BidServiceTest {

    @Autowired
    private BidService bidService;
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    

//    @AfterEach
//    void tearDown() {
//        bidRepository.deleteAll();
//    }

    @Test
    public void testThatBidPlacedForAnAuctionIsAchieved() {
        Product product = new Product();
        product.setProductName("Gucci Top");
        product.setCategory("Clothing");
        product.setDescription("Outdated Gucci Top");
        product.setStartingPrice(50.00);
        product.setAuctionStartTime(LocalTime.of(2, 4, 0));
        product.setAuctionEndTime(LocalTime.of(2, 4, 59));
        product.setTimeStamp(LocalTime.of(3,0,0));

        productRepository.save(product);
        double bidAmount = 150.00;
        Bid bid = new Bid();
        bid.setBidAmount(bidAmount);

        Bid bid1 = bidService.placeABidForAnAuctionBid(product,bid);

        assertEquals(LocalTime.of(3, 0, 0), product.getTimeStamp());
        assertEquals(bidAmount, bid1.getBidAmount(), 0.01);
        assertEquals(bidAmount, product.getCurrentBidAmount(), 0.01);
    }


    @Test
    public void testThatBidCanBeCancelled(){
        User user = new User();
        user.setUserName("user");
        user.setPassword("password");
        user.setEmail("email");
        user.setGender(Gender.FEMALE);
        userRepository.save(user);

        Product product = new Product();
        product.setProductName("Gucci Top");
        product.setCurrentBidAmount(60.00);
        product.setCategory("Clothing");
        product.setDescription("Outdated Gucci Top");
        product.setStartingPrice(50.00);
       product.setAuctionStartTime(LocalTime.of(2, 4, 0));
        product.setAuctionEndTime(LocalTime.of(2, 4, 59));
        product.setTimeStamp(LocalTime.of(3, 0, 0));
        productRepository.save(product);

        Bid bid = new Bid();
        bid.setBidAmount(1000.00);
        bid.setProduct(product);
        bid.setUser(user);
        bidRepository.save(bid);


        Bid cancelledBid = bidService.cancelBid(bid,user,product);
        assertEquals(50.00,product.getStartingPrice());

    }

    @Test
    public void testThatBidCanBeViewed() {
        Product product = new Product();

        product.setProductName("Gucci Top");
        product.setCurrentBidAmount(50.00);
        product.setCategory("Clothing");
        product.setDescription("Outdated Gucci Top");
        product.setStartingPrice(50.00);
        product.setAuctionStartTime(LocalTime.of(2, 4, 0));
        product.setAuctionEndTime(LocalTime.of(2, 4, 59));
        product.setTimeStamp(LocalTime.of(3, 0, 0));
        productRepository.save(product);

        Bid bid = new Bid();
        bid.setBidAmount(50.00);
        bid.setProduct(product);
        bidRepository.save(bid);
        Bid savedBid = bidRepository.findById(bid.getId()).orElseThrow();

        Bid result = bidService.viewBid(bid);
        assertEquals(bid, result);
    }
    @Test
    public void testThatBidCanBeUpdated() throws BidTooLowException {

        Product product = new Product();
        product.setProductName("Gucci Top");
        product.setCurrentBidAmount(100.00);
        product.setCategory("Clothing");
        product.setDescription("Outdated Gucci Top");
        product.setStartingPrice(50.00);
        product.setAuctionStartTime(LocalTime.of(2, 4, 0));
        product.setAuctionEndTime(LocalTime.of(2, 4, 59));
        product.setTimeStamp(LocalTime.of(3, 0, 0));
        productRepository.save(product);

        Bid bid = new Bid();
        bid.setProduct(product);
        bid.setBidAmount(100.00);
        bid = bidRepository.save(bid);

        double newAmount = 150.00;
        Bid updatedBid = bidService.updateBid(bid, newAmount);


        assertEquals(newAmount, updatedBid.getBidAmount(), 0.01);
        assertEquals(newAmount, product.getCurrentBidAmount(), 0.01);
        assertNotEquals(100.00, updatedBid.getBidAmount());
    }

    @Test
    public void testThatYouCanGetBidByProduct() {
        Product product = new Product();
        product.setProductName("Gucci Top");
        product.setCategory("Clothing");
        product.setDescription("Outdated Gucci Top");
        product.setStartingPrice(100.0);
        product.setCurrentBidAmount(100.0);
        product.setTimeStamp(LocalTime.of(3, 0, 0));
        product = productRepository.save(product);

        Bid bid = new Bid();
        bid.setProductId(product.getId());
        bid.setBidAmount(120.0);

        bidRepository.save(bid);

        List<Bid> bids = bidService.getBidsForProduct(product.getId());

        assertFalse(bids.isEmpty());
        assertEquals(1, bids.size());
        assertEquals("Gucci Top", product.getProductName());
        assertEquals("Clothing",product.getCategory());
        assertEquals("Outdated Gucci Top",product.getDescription());
        assertEquals(120.0, bids.get(0).getBidAmount(), 0.01);
    }

}
