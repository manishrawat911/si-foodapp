package com.example.billingservice.business;

import com.example.billingservice.adapters.PaymentClient;
import com.example.billingservice.business.entities.Invoice;
import com.example.billingservice.business.utilities.InvoiceUtility;
import com.example.billingservice.dto.*;
import com.example.billingservice.ports.InvoiceManagement;
import com.example.billingservice.ports.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.example.billingservice.ports.PolicyManager;

import java.util.List;

@Service
public class InvoiceManager implements InvoiceManagement {
    PaymentClient paymentClient;
    InvoiceRepository repository;
//    PolicyManager policyManager;

    @Autowired
    public InvoiceManager(InvoiceRepository repository, PaymentClient paymentClient) {
        this.repository = repository;
        this.paymentClient = paymentClient;
    }


    public Invoice getInvoice(Long req){
        return repository.getInvoiceByInvoiceId(req);
//        return ;
    }
    public CreateInvoiceResponse createInvoice(CreateInvoiceRequest req){
        ///calculate tax
        Invoice invoice = InvoiceUtility.createInvoice(req);
//        invoice.setCartId(req.getCartId());
        invoice.setPaymentReference(paymentClient.debit(new CardDetails()).getReferenceNumber());
        invoice = repository.save(invoice);
        CreateInvoiceResponse response = new CreateInvoiceResponse();
        response.setInvoiceId(invoice.getInvoiceId());
        response.setStatus("SUCCESS"); //Need to be updated with paymentClient response -will do later

        return response;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return repository.findAll();
    }
}