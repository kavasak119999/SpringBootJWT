package dev.max.service;

import dev.max.dto.Product;
import dev.max.entity.ProductEntity;
import dev.max.repository.ProductRepository;
import dev.max.utils.DtoToEntity;
import dev.max.utils.EntityToDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProducts(List<Product> products) {
        List<ProductEntity> entities = products.stream()
                .map(DtoToEntity::productDtoToEntity).toList();

        productRepository.saveAll(entities);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll()
                .stream().map(EntityToDto::productEntityToDto).toList();
    }
}
