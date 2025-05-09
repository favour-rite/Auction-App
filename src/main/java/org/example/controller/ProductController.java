package org.example.controller;


import org.example.data.models.Product;
import org.example.dtos.Request.ProductRequest;
import org.example.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;
    private ProductRequest productRequest;

    @PostMapping("/signUp")
    public ResponseEntity<Product> signUp(@RequestBody ProductRequest ProductRequest) {
        Product createdProduct = productServiceImpl.createProduct("productRequest");
        return ResponseEntity.ok(productServiceImpl.createProduct("createdProduct"));
    }

}
