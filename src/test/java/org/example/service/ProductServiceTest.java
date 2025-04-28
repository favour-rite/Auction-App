//package org.example.service;
//
//import org.example.data.models.Product;
//import org.example.data.repository.ProductRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalTime;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(classes = ProductServiceTest.class)
//class ProductServiceTest {
//
//    @Autowired
//    private ProductService productService;
//    @Autowired
//    private ProductRepository productRepository;
//
//
//    @AfterEach
//    void tearDown() {
//        productRepository.delectAll();
//    }
//
//    @Test
//    public void testThatProductCanBeCreated() {
//        Product product = new Product();
//        product.setProductName("productName");
//        product.setCategory("category");
//        product.setImageUrl("imageUrl");
//        product.setDescription("description");
//        product.setStartingPrice(50.00);
//
//        product.setAuctionStartTime(LocalTime.of(2, 4, 0));
//        product.setAuctionEndTime(LocalTime.of(2, 4, 59));
//
//        Product product1 = productService.createProduct("productName", "description", 80.00, "category", "imageUrl",
//                LocalTime.of(2, 4, 0),
//                LocalTime.of(2, 4, 59));
//
//        assertEquals("productName", product1.getProductName());
//        assertEquals("category", product1.getCategory());
//        assertEquals("imageUrl", product1.getImageUrl());
//        assertEquals("description", product1.getDescription());
//        assertEquals(80.00, product1.getStartingPrice(), 0.00);
//        assertEquals(LocalTime.of(2, 4, 0), product1.getAuctionStartTime());
//        assertEquals(LocalTime.of(2, 4, 59), product1.getAuctionEndTime());
//
//        assertEquals(1, productRepository.count());
//
//    }
//    @Test
//    public void testThatProductDetailsCanBeUpdated(){
//        Product product = new Product();
//        product.setProductName("productName");
//        product.setCategory("category");
//        product.setImageUrl("imageUrl");
//        product.setDescription("description");
//        product.setStartingPrice(50.00);
//        product.setAuctionStartTime(LocalTime.of(2, 1, 0));
//        product.setAuctionEndTime(LocalTime.of(2, 2, 59));
//
//        Product product1 = productService.updateProduct("productName", "description", 80.00, "category", "imageUrl",
//                LocalTime.of(2, 1, 0),
//                LocalTime.of(2, 2, 59));
//
//        assertEquals("productName", product1.getProductName());
//        assertEquals("category", product1.getCategory());
//        assertEquals("imageUrl", product1.getImageUrl());
//        assertEquals("description", product1.getDescription());
//        assertEquals(50.00, product1.getStartingPrice(), 0.00);
//        assertEquals(LocalTime.of(2, 1, 0), product1.getAuctionStartTime());
//        assertEquals(LocalTime.of(2, 2, 59), product1.getAuctionEndTime());
//        assertEquals(1, productRepository.count());
//    }
//    @Test
//    public void testThatProductCanBeDeleted(){
//
//        Product product = new Product();
//        product.setProductName("productName");
//        product.setCategory("category");
//        product.setImageUrl("imageUrl");
//        product.setDescription("description");
//        product.setStartingPrice(50.00);
//
//        Product product1 = productService.delectProduct("productName", "description", 80.00, "category", "imageUrl",
//                LocalTime.of(2, 1, 5),
//                LocalTime.of(2, 2, 3));
//
//        assertEquals("productName", product1.getProductName());
//        assertEquals("category", product1.getCategory());
//        assertEquals("imageUrl", product1.getImageUrl());
//        assertEquals("description", product1.getDescription());
//        assertEquals(50.00, product1.getStartingPrice(), 0.00);
//        assertEquals(LocalTime.of(2, 1, 5), product1.getAuctionStartTime());
//        assertEquals(LocalTime.of(2, 2, 3), product1.getAuctionEndTime());
//        assertEquals(1, productRepository.count());
//    }
//    @Test
//    public void testThatProductCanBeViewed(){
//
//    }
//
//
//}