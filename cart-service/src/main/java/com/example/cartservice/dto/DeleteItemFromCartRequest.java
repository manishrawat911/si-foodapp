package com.example.cartservice.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import java.io.Serializable;

@Value
@Getter @Setter
public class DeleteItemFromCartRequest implements Serializable {

    @NonNull Long cartId;
    @NonNull Long userId;
    @NonNull Long itemId;
    @NonNull int quantity;
}
