package com.example.productcatalogservice.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class AddGoodiesRequest {
    public final @NonNull  String goodieName;
    public final @NonNull Float mddPoint;
}
