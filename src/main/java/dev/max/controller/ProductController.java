package dev.max.controller;


import dev.max.dto.Product;
import dev.max.dto.ProductRequest;
import dev.max.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final String TABLE_NAME = "products";
    private final ProductService productService;

    @PostMapping("/add")
    public void addProducts(@RequestBody ProductRequest request) {
        if (TABLE_NAME.equals(request.getTable()))
            productService.saveProducts(request.getRecords());
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
