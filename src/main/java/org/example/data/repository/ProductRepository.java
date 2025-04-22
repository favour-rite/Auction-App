package org.example.data.repository;

import org.example.data.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    void save(Product product);

    <T> ScopedValue<T> findById(String productId);

    void update(Product product);

    void delete(Product product);

    int count();

    void delectAll();
}
