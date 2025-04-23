package org.example.service;

import org.example.data.models.Product;
import org.example.data.repository.ProductRepository;
import org.example.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(String productName, String description, double startingPrice, String category, String imageUrl, LocalTime auctionStartTime, LocalTime auctionEndTime)
            throws ProductNotFoundException {

        Product product = new Product();
        product.setProductName(productName);
        product.setDescription(description);
        product.setStartingPrice(startingPrice);
        product.setAuctionStartTime(auctionStartTime);
        product.setAuctionEndTime(auctionEndTime);
        product.setImageUrl(imageUrl);
        product.setCategory(category);

        productRepository.save(product);

        return product;
    }

    public Product updateProduct(String productName, String newDescription, double newStartingPrice, String category, String imageUrl, LocalTime auctionStartTime, LocalTime auctionEndTime) {
        Product product = new Product();
        product.setProductName(productName);
        product.setDescription(newDescription);
        product.setCategory(category);
        product.setStartingPrice(newStartingPrice);
        product.setAuctionStartTime(auctionStartTime);
        product.setAuctionEndTime(auctionEndTime);
        product.setImageUrl(imageUrl);
        productRepository.update(product);

        return product;
    }

    public Product viewProduct()
    {
        return productRepository.findById();
    }

    public Product delectProduct(String productName, String description, double startingPrice, String category, String imageUrl, LocalTime auctionStartTime, LocalTime auctionEndTime) {

        Product product = new Product();
        product.setProductName(productName);
        product.setCategory(category);
        product.setDescription(description);
        product.setStartingPrice(startingPrice);
        product.setAuctionStartTime(auctionStartTime);
        product.setAuctionEndTime(auctionEndTime);
        product.setImageUrl(imageUrl);


        productRepository.delete(product);
        return product;
    }




}
