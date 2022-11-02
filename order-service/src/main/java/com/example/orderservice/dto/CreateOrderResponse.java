package com.example.orderservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateOrderResponse {
    Long orderId;
    String status;
}
