package org.example.service;

import org.example.data.models.Product;
import org.example.exception.ProductNotFoundException;

import java.time.LocalTime;

public interface ProductService {
    Product createProduct(String productName, String description, double startingPrice, String category, String imageUrl, LocalTime auctionStartTime, LocalTime auctionEndTime)
            throws ProductNotFoundException;

    Product updateProduct(String productName, String newDescription, double newStartingPrice, String category, String imageUrl, LocalTime auctionStartTime, LocalTime auctionEndTime);

    Product viewProduct();

    Product delectProduct(String productName, String description, double startingPrice, String category, String imageUrl, LocalTime auctionStartTime, LocalTime auctionEndTime);
}
