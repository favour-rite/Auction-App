package org.example.service;

import org.example.data.models.Bid;
import org.example.data.models.Product;
import org.example.data.models.User;
import org.example.exception.BidTooLowException;
import org.example.exception.CannotCancelSomeoneElseBid;
import org.example.exception.ProductNotFoundException;
import org.example.exception.UserNotFoundException;

import java.util.List;

public interface BidService {

    Bid placeABidForAnAuctionBid(Product product, Bid bid) throws ProductNotFoundException, UserNotFoundException;

    Bid updateBid(Bid bid, double newBidAmount) throws BidTooLowException;

    Bid cancelBid(Bid bid, User user, Product product) throws CannotCancelSomeoneElseBid;

    Bid viewBid(Bid bid);

    List<Bid> getBidsForProduct(String productId);
}
