package com.example.billingservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Getter @Setter
//@NoArgsConstructor
//@Jacksonized
public class PaymentGatewayResponse {
    Long referenceNumber;
    String message;
    String status;
}
