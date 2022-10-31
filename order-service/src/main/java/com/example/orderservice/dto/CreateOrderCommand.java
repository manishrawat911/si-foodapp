package com.example.orderservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateOrderCommand {
    Long cartId;
    Long invoiceId;
}
