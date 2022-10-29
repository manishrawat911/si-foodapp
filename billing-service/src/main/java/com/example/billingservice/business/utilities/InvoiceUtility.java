package com.example.billingservice.business.utilities;

import com.example.billingservice.business.entities.Invoice;
import com.example.billingservice.dto.CreateInvoiceRequest;

public class InvoiceUtility {

    enum Status{
        CREATED,
        FAILED,
        SUCCESS
    }
    public static Invoice createInvoice(CreateInvoiceRequest req){
        Invoice invoice = new Invoice();
        invoice.setCartId(req.getCartId());
        invoice.setTotalAfterTax(req.getCartTotal()* 1.13f);
        return invoice;
    }

//    static boolean setInvoiceStatus(Invoice invoice, Status status){
//        invoice
//        return true;
//    }
}
