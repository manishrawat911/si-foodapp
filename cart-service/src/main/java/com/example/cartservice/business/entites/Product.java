package com.example.cartservice.business.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter @Setter
@NoArgsConstructor

public class Product {

    Long productId;
    String productName;
    public Float price;
    Long providerId;
    int quantity;


    public Product(Long productId, String productName, Float price, Long providerId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.providerId = providerId;
    }
}
