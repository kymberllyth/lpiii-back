package com.fiec.lpiiiback.services.impl;

import com.fiec.lpiiiback.models.dto.ProductRequestDto;
import com.fiec.lpiiiback.models.entities.Product;
import com.fiec.lpiiiback.models.repositories.ProductRepository;
import com.fiec.lpiiiback.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product insertNewProduct(ProductRequestDto productRequestDto, String productImage) {
        return productRepository.save(
                Product.builder()
                        .description(productRequestDto.getDescription())
                        .name(productRequestDto.getName())
                        .price(productRequestDto.getPrice())
                        .productImage(productImage)
                        .build()
        );
    }
}
