package org.example.service;

import org.example.data.models.Bid;
import org.example.data.models.Product;

import org.example.data.models.User;
import org.example.data.repository.BidRepository;
import org.example.data.repository.ProductRepository;
import org.example.data.repository.UserRepository;
import org.example.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl extends  {

    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public Bid placeABidForAnAuctionBid(Product product, Bid bid) throws ProductNotFoundException, UserNotFoundException {
        if (product == null) {
            throw new ProductNotFoundException("Product not found");
        }
        if (bid.getBidAmount() <= product.getCurrentBidAmount()) {
            throw new IllegalArgumentException("Bid amount must be higher than current bid");
        }
        bidRepository.save(bid);
        product.setCurrentBidAmount(bid.getBidAmount());
        productRepository.save(product);
        return bid;
    }

    public Bid updateBid(Bid bid, double newBidAmount) throws BidTooLowException {
        if (newBidAmount <= bid.getProduct().getCurrentBidAmount()) {
            throw new BidTooLowException("Bid amount too low");
        }

        bid.setBidAmount(newBidAmount);

        bid.getProduct().setCurrentBidAmount(newBidAmount);
        productRepository.save(bid.getProduct());

        return bid;
    }

    public Bid cancelBid(Bid bid, User user,Product product) throws CannotCancelSomeoneElseBid {
      userRepository.findById(user.getID())
              .orElseThrow(() -> new UserNotFoundException("User not found"));
      if (!bid.getUser().equals(user)) {
          throw new CannotCancelSomeoneElseBid("Cannot cancel someone else's bid, Cancel Yours");
      }
      if (product == null) {
          throw new ProductNotFoundException("Product not found");
      }
      bidRepository.delete(bid);
      bid.getProduct().setCurrentBidAmount(bid.getBidAmount());
      productRepository.save(bid.getProduct());
      return bid;
    }

    public Bid viewBid(Bid bid) {
        return bidRepository.findById(bid.getId())
                .orElseThrow(() -> new BidNotFoundException("Bid not found"));
    }

    public List<Bid> getBidsForProduct(String productId) {
        List<Bid> bids = bidRepository.findByProductId(productId);
        if (bids.isEmpty()) {
            throw new ProductNotFoundException("No bids found for product with ID " + productId);
        }
        return bids;
    }

}
