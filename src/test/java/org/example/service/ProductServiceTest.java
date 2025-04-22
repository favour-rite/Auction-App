package org.example.service;

import org.example.data.models.Product;
import org.example.data.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ProductServiceTest.class)
class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;


    @AfterEach
    void tearDown() {
        productRepository.delectAll();
    }

    @Test
    public void testThatProductCanBeCreated(){
        Product product = new Product();
        product.setProductName("productName");
        product.setCategory("category");
        product.setImageUrl("imageUrl");
        product.setDescription("description");
        product.setStartingPrice(50.00);
        product.setAuctionStartTime();
        product.setAuctionEndTime();

        Product product1 = productService.createProduct("productName", "description",80.00,"category","imageUrl",02:04:22);
        assertEquals("productName", product.getProductName());
        assertEquals("category", product.getCategory());
        assertEquals("imageUrl", product.getImageUrl());
        assertEquals("description", product.getDescription());
        assertEquals(50.00, product.getStartingPrice(), 0.00);
        assertEquals(1, productRepository.count());

    }
    @Test
    public void testThatProductDetailsCanBeUpdated(){
        Product product = new Product();
        product.setProductName("productName");
        product.setCategory("category");
        product.setImageUrl("imageUrl");
        product.setDescription("description");
        product.setStartingPrice(50.00);
        product.setAuctionEndTime();
        product.setAuctionEndTime();

        Product product1 = productService.updateProduct("productName","description",40.00,"category","imageUrl","");
        assertEquals("productName", product.getProductName());
        assertEquals("category", product.getCategory());
        assertEquals("imageUrl", product.getImageUrl());
        assertEquals("description", product.getDescription());
        assertEquals(50.00, product.getStartingPrice(), 0.00);
        assertEquals(1, productRepository.count());
    }
    @Test
    public void testThatProductCanBeDeleted(){
        Product product = new Product();
    }


}