package com.example.productcatalogservice.business.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Provider {
    private @Id @GeneratedValue Long providerId;
}
