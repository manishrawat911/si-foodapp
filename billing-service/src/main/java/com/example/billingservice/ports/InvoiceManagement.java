package com.example.billingservice.ports;

import com.example.billingservice.business.entities.Invoice;
import com.example.billingservice.dto.CreateInvoiceRequest;
import com.example.billingservice.dto.CreateInvoiceResponse;
import com.example.billingservice.dto.GetInvoiceResponse;

import java.util.List;

public interface InvoiceManagement {
//    public Invoice getInvoice(GetInvoiceRequest req);
    public CreateInvoiceResponse createInvoice(CreateInvoiceRequest req);
//    public GetInvoiceResponse getInvoice(Long req);

    public List<Invoice> getAllInvoices();

    public Invoice getInvoice(Long id);

}