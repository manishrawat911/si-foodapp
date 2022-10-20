package com.example.productcatalogservice.business.entites;

import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    private @Id @GeneratedValue Long productId;
    private String productName;
    private String productDescription;
//    private Provider provider;
    private Float price;

}
