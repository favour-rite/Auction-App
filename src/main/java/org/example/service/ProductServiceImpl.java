//package org.example.service;
//
//import org.example.data.models.Product;
//import org.example.data.models.User;
//import org.example.data.repository.ProductRepository;
//import org.example.data.repository.UserRepository;
//import org.example.exception.ProductMustBeUniqueException;
//import org.example.exception.ProductNotFoundException;
//import org.example.exception.UserNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductServiceImpl implements ProductService {
//
//
//    private final UserRepository userRepository;
//    private ProductRepository productRepository;
//
//    public ProductServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public Product createProduct(Product product, User user) throws ProductNotFoundException {
//        productRepository.findById(productName).orElseThrow(() -> new ProductNotFoundException(productName));
//        userRepository.findById("userId").orElseThrow(() -> new UserNotFoundException("userId"));
//        if(productRepository.findById(productName).equals(productRepository.findById(productName))) {
//            throw new ProductMustBeUniqueException("Your product must not be obtain same credentials");
//        }
//        productRepository.save(product);
//        return product;
//    }
//
//    @Override
//    public Product updateProduct(Product product) {
//        if(!productRepository.existsById("productId")) {
//            throw new ProductNotFoundException("Product not found by id, So you cant update product");
//        }
//        product = new Product();
//        productRepository.save(product);
//
//        return product;
//    }
//
//    @Override
//    public Product viewProduct() {
//
//        if(productRepository.findById("productId").isPresent()) {
//            return productRepository.findById("productId").get();
//        }
//        return null;
//    }
//    @Override
//    public Product delectProduct(Product product) {
//        if(!productRepository.findById("productId").equals(productRepository.findById("productId"))) {
//            throw new ProductNotFoundException("Product not found by id, So you cant delete product");
//        }
//        productRepository.delete(product);
//        return product;
//    }
//
//
//}
