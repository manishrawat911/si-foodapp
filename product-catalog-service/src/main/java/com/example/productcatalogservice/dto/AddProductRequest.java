package com.example.productcatalogservice.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class AddProductRequest {

    public final @NonNull String productName;
    public final @NonNull String productDescription;
    public final @NonNull Float price;

}