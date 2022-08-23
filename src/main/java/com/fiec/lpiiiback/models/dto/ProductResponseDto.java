package com.fiec.lpiiiback.models.dto;


import com.fiec.lpiiiback.models.entities.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponseDto {
    private String productId;

    private String name;
    private String description;

    private Double price;

    private String productImage;

    public static ProductResponseDto convert(Product product){

        return ProductResponseDto.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .productId(product.getProductId())
                .productImage(product.getProductImage())
                .build();
    }
}
