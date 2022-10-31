package com.example.billingservice.dto;

import java.io.Serializable;

//@Value
public class ChargeDebitCardCommand implements Serializable {
    String debitCardNumber;
    String debitCardPin;
    Float amount;
}
