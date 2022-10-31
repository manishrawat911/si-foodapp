package com.example.billingservice.ports;

import com.example.billingservice.dto.CardDetails;

public interface PaymentService {

    boolean debit(CardDetails req);
    boolean credit(CardDetails req);
}
