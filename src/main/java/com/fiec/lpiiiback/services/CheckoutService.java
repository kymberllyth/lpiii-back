package com.fiec.lpiiiback.services;

import com.fiec.lpiiiback.models.entities.Checkout;
import com.fiec.lpiiiback.models.entities.Product;

import java.util.List;

public interface CheckoutService {

    Checkout saveCheckout(List<Product> productList);
}
