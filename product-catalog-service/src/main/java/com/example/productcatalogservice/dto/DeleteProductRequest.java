package com.example.productcatalogservice.dto;

import com.example.productcatalogservice.business.entites.Provider;
import lombok.NonNull;
import lombok.Value;

@Value
public class DeleteProductRequest {
    @NonNull Long productId;
    @NonNull Provider providerId;
}
