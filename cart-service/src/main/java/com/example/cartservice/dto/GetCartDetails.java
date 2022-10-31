package com.example.cartservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GetCartDetails {

    Long cartId;

    public GetCartDetails(Long cartId)
    {
        this.cartId = cartId;
    }

}
