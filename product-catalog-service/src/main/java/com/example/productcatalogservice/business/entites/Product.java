package com.example.productcatalogservice.business.entites;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter

public class Product {
    private @Id @GeneratedValue Long productId;
    private String productName;
    private String productDescription;
//    private Provider provider;
    private Float price;

    private Long provider;

    public Product(String productName, String productDescription, Float price, Long provider) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.provider = provider;
    }
}
