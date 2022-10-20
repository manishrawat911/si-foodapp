package com.example.cartservice.dto;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Value
public class AddItemToCartRequest extends CartRequest implements Serializable  {

    @NotNull int itemQty;

}
