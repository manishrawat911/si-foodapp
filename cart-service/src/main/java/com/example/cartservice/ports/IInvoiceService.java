package com.example.cartservice.ports;

import com.example.cartservice.business.entites.Cart;

public interface IInvoiceService {

    void sendInvoice(Cart cart);
    
}
