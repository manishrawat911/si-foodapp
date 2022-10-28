package com.example.productcatalogservice.dto;

import com.example.productcatalogservice.business.entites.Product;
import com.example.productcatalogservice.business.entites.Provider;
import lombok.NonNull;
import lombok.Value;

@Value
public class AddProductRequest {

    public final @NonNull String productName;
    public final @NonNull String productDescription;
    public final @NonNull Float price;

//    public final @NonNull Provider providerId;
    public final @NonNull Long providerId;
}