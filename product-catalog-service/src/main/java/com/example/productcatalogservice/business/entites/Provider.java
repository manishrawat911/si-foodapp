package com.example.productcatalogservice.business.entites;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Provider {
    private @Id @GeneratedValue Long providerId;

    public Provider(Long providerId)
    {
        this.providerId = providerId;
    }
}
