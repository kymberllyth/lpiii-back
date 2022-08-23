package com.fiec.lpiiiback.models.dto;

import com.fiec.lpiiiback.models.entities.Checkout;
import com.fiec.lpiiiback.models.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CheckoutResponseDto {
    private String id;
    private Date createdOn;
    private Date updatedOn;
    List<ProductResponseDto> products;
    private Double totalPrice;

    public static CheckoutResponseDto convert(Checkout checkout){
        List<Product> productList = checkout.getProducts();
        return CheckoutResponseDto.builder()
                .id(checkout.getCheckoutId())
                .createdOn(checkout.getCreatedOn())
                .updatedOn(checkout.getUpdatedOn())
                .products(productList.stream().map(ProductResponseDto::convert).collect(Collectors.toList()))
                .totalPrice(productList.stream().mapToDouble(Product::getPrice).sum())
                .build();
    }
}
