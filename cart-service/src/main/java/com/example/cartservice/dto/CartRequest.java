package com.example.cartservice.dto;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter

public class CartRequest implements Serializable {
    @NonNull Long cartId;
    @NonNull Long userId;

    public CartRequest(Long cartId,Long userId)
    {
        this.cartId = cartId;
        this.userId = userId;
    }

}
