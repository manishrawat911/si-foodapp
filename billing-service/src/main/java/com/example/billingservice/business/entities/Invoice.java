package com.example.billingservice.business.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString
public class Invoice {
    @Id @GeneratedValue
    Long invoiceId;

    Long cartId;

    Float totalAfterTax;

    Long paymentReference;
}
