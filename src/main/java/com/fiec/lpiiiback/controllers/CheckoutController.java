package com.fiec.lpiiiback.controllers;


import com.fiec.lpiiiback.models.dto.CheckoutRequestDto;
import com.fiec.lpiiiback.models.dto.CheckoutResponseDto;
import com.fiec.lpiiiback.models.entities.Product;
import com.fiec.lpiiiback.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/checkouts")
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;

    @PostMapping
    public CheckoutResponseDto checkoutProducts(@RequestBody CheckoutRequestDto checkoutRequestDto){
        return CheckoutResponseDto.convert(checkoutService.saveCheckout(checkoutRequestDto.getProducts()
                .stream().map(p -> Product.builder()
                        .productId(p.getProductId())
                        .name(p.getName())
                        .description(p.getDescription())
                        .productImage(p.getProductImage())
                        .price(p.getPrice())
                        .build())
                .collect(Collectors.toList())));
    }
}
