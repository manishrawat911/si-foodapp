package com.example.cartservice.dto;


import lombok.NonNull;

import java.io.Serializable;

public class CartRequest implements Serializable {
    @NonNull String cartId;
    @NonNull String itemId;
}
