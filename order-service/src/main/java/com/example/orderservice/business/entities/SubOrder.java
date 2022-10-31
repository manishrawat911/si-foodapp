package com.example.orderservice.business.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class SubOrder {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subOrderId;

    @NotNull
    private Long orderId;

    @NotNull
    private Long provideId;

    @NotNull
    private Long productId;

    @NotNull
    private String status;
}
