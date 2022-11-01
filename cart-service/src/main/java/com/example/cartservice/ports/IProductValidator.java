package com.example.cartservice.ports;

import com.example.cartservice.business.entites.Product;

public interface IProductValidator {
    Product getProduct(Long id);
}
