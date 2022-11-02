package com.example.billingservice.business;

import com.example.billingservice.adapters.OrderClient;
import com.example.billingservice.adapters.PaymentClient;
import com.example.billingservice.business.entities.Invoice;
import com.example.billingservice.business.policies.InvoiceEvents;
import com.example.billingservice.business.policies.InvoicePolicy;
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
    OrderClient orderClient;
    InvoicePolicy invoicePolicy;

    @Autowired
    public InvoiceManager(InvoiceRepository repository,
                          PaymentClient paymentClient,
                          OrderClient orderClient,
                          InvoicePolicy invoicePolicy) {
        this.repository = repository;
        this.paymentClient = paymentClient;
        this.orderClient = orderClient;
        this.invoicePolicy = invoicePolicy;
    }


    public Invoice getInvoice(Long req){
        return repository.getInvoiceByInvoiceId(req);
//        return ;
    }
    public CreateInvoiceResponse createInvoice(CreateInvoiceRequest req){
        CreateInvoiceResponse response = new CreateInvoiceResponse();
        try
        {
            ///calculate tax
            // Payment Part
            Invoice invoice = InvoiceUtility.createInvoice(req);


            invoice.setPaymentReference(paymentClient.debit(new CardDetails()).getReferenceNumber());
            invoice = repository.save(invoice);
            response.setInvoiceId(invoice.getInvoiceId());
            response.setStatus("PAYMENT_SUCCESS");

            // Sending invoice to order managment for further processing
            invoicePolicy.paymentSuccess(invoice);
        }
        catch (Exception ex){

        }

        return response;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return repository.findAll();
    }
}