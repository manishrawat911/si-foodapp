package com.example.cartservice.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;

@Value @Getter @Setter
public class GetItemDetails {
    @NonNull Long productId;
}
