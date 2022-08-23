package com.fiec.lpiiiback.services;

import com.fiec.lpiiiback.models.dto.ProductRequestDto;
import com.fiec.lpiiiback.models.dto.ProductResponseDto;
import com.fiec.lpiiiback.models.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();
    Product insertNewProduct(ProductRequestDto productRequestDto, String productImage);

}
