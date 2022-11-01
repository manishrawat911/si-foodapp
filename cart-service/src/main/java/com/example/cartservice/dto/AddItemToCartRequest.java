package com.example.cartservice.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

@Value
@Getter @Setter
public class AddItemToCartRequest implements Serializable  {

    Long cartid;
    Long userId;
    Long itemId;
    int quantity;

}
