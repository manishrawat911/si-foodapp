package com.example.productcatalogservice.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class DeleteGoodiesRequest {
    @NonNull Long goodiesId;
}
