package dev.max.service;

import dev.max.dto.Product;

import java.util.List;

public interface ProductService {
    void saveProducts(List<Product> products);
    List<Product> getAllProducts();
}
