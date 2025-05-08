package org.example.data.repository;

import org.example.data.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    void delete(Product product);
    void  deleteAll();
    Product findByProductName(String productName);

    void delectAll();
}
