package com.example.billingservice.business.policies;

import com.example.billingservice.adapters.OrderClient;
import com.example.billingservice.business.entities.Invoice;
import com.example.billingservice.dto.CreateInvoiceResponse;
import com.example.billingservice.dto.CreateOrderRequest;
import com.example.billingservice.dto.CreateOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoicePolicy {

    OrderClient orderClient;

    @Autowired
    public InvoicePolicy(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    public void execute(String event){
        if(event.equals(InvoiceEvents.PAYMENT_SUCCESS)){

        }
    }
    public void paymentSuccess(Invoice invoice){
        CreateOrderRequest request = new CreateOrderRequest();
        request.setInvoiceId(invoice.getInvoiceId());
        request.setCartId(invoice.getCartId());

        CreateOrderResponse response = orderClient.send(request);
    }
}
