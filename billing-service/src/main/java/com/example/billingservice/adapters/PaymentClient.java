package com.example.billingservice.adapters;

import com.example.billingservice.dto.CardDetails;
import com.example.billingservice.dto.ChargeDebitCardCommand;
import com.example.billingservice.dto.PaymentGatewayResponse;
import org.springframework.stereotype.Service;

import java.util.Random;

//@Path("/hello-world")
@Service
public class PaymentClient {
//    @GET
//    @Produces("text/plain")
//    String hello(@QueryParam("name") String name);

    public PaymentGatewayResponse debit(CardDetails req){
        PaymentGatewayResponse response = new PaymentGatewayResponse();
        response.setMessage("Payment Successful");
        response.setReferenceNumber(new Random().nextLong());
        response.setStatus("Success");
        return response;
    }
}