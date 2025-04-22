package org.example.service;

import org.example.data.enums.AuctionStatus;
import org.example.data.models.Bid;
import org.example.data.models.Product;

import org.example.data.models.User;
import org.example.data.repository.BidRepository;
import org.example.data.repository.ProductRepository;
import org.example.data.repository.UserRepository;
import org.example.exception.BidTooLowException;
import org.example.exception.UnauthorizedActionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuctionStatus auctionStatus;


    public Bid placeABidForTheAuctionBid(String productId,String auctionEndTime,String bidderUsername,Double bidAmount) {

        Product product = productRepository.findById(productId);
        if (bidAmount <= product.getCurrentBidAmount()) {
            throw new IllegalArgumentException ("Bid amount must be higher than current bid");
        }
        Bid bid = new Bid();
        bid.setProductId(productId);
        bid.setActualBidAmount(bidAmount);
        bid.setBidderUserName(bidderUsername);
        bid.setTimeStamp(System.currentTimeMillis());

        bidRepository.save(bid);

        product.setCurrentBidAmount(bidAmount);
        productRepository.save(product);

        return bid;
    }
    public Bid updateBid(Bid bid, double newBidAmount) throws BidTooLowException {
        if (newBidAmount <= bid.getProduct().getCurrentBidAmount()) {
            throw new BidTooLowException("Bid amount too low");
        }
        bid.setActualBidAmount(newBidAmount);
        bidRepository.update(bid);
        bid.getProduct().setCurrentBidAmount(newBidAmount);
        productRepository.update(bid.getProduct());
        return bid;
    }
    public List<Bid> getBidsForProduct(String productId) {
        return bidRepository.findByProductId(productId);
    }
    public Bid cancelBid(Bid bid, User currentUser) throws UnauthorizedActionException {
        if (!bid.getUser().equals(currentUser)) {
            throw new UnauthorizedActionException("Cannot cancel someone else's bid");
        }
        bidRepository.delete(bid);
        bid.getProduct().setCurrentBidAmount(bid.getActualBidAmount());
        productRepository.update(bid.getProduct());
        return bid;
    }

    public Bid viewBid(Bid bid) {
        return bidRepository.findById(bid.getId());
    }
}
