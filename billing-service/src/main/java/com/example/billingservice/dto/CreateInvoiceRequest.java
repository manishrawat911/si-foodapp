package com.example.billingservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

//@Value
@Getter @Setter
public class CreateInvoiceRequest {
    Long cartId;
    Float cartTotal;
    CardDetails cardDetails;
}
