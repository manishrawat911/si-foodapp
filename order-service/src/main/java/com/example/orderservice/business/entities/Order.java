package com.example.orderservice.business.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.IdGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "D_Orders")
@Setter @Getter
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @NotNull
    private Long cartId;

    @NotNull
    private Long invoiceId;

    @NotNull
    private String status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
