package com.example.billingservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

//@Value
@Getter @Setter
//@NoArgsConstructor
public class CreateInvoiceResponse {
    public Long invoiceId;
    public String status;
}
