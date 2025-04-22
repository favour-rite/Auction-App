package org.example.service;

import org.example.data.models.Product;
import org.example.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(String productName, String description, double startingPrice, String category, String imageUrl, Date auctionStartTime) {
        Product product = new Product();
        product.setProductName(productName);
        product.setDescription(description);
        product.setStartingPrice(startingPrice);
        product.setAuctionEndTime(auctionStartTime);
        product.setAuctionStartTime(auctionStartTime);
        product.setImageUrl(imageUrl);
        product.setCategory(category);
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(String productName, String newDescription, double newStartingPrice, String category, String imageUrl, Date auctionStartTime) {
        Product product = new Product();
        product.setDescription(newDescription);
        product.setCategory(category);
        product.setStartingPrice(newStartingPrice);
        product.setAuctionEndTime(auctionStartTime);
        product.setAuctionStartTime(auctionStartTime);
        product.setImageUrl(imageUrl);
        productRepository.update(product);

        return product;
    }

    public String deleteProduct(Product product) {
        productRepository.delete(product);
        return "Product deleted successfully";
    }

    public Product viewProduct(Product product) {
        return productRepository.findById();
    }

}
