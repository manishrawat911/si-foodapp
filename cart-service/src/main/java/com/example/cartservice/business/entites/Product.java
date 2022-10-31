package com.example.cartservice.business.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "Product_Database")
public class Product {

    @Id Long productId;
    String productName;
    public Float price;
    Long provider;
    int quantity;
    Long cartId;

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "cartId", referencedColumnName = "cartId",updatable = false,insertable = false)
    @JsonBackReference
    private Cart cart;


    public Product(Long productId, String productName, Float price, Long providerId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.provider = providerId;
    }
}
