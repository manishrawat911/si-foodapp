package com.example.billingservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateOrderRequest {
    Long invoiceId;
    Long cartId;
}
