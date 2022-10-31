package com.example.billingservice.adapters;

import com.example.billingservice.business.entities.Invoice;
import com.example.billingservice.dto.CreateInvoiceRequest;
import com.example.billingservice.dto.CreateInvoiceResponse;
import com.example.billingservice.dto.GetInvoiceRequest;
import com.example.billingservice.dto.GetInvoiceResponse;
import com.example.billingservice.ports.InvoiceManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/billing", produces = "application/json")
public class BillingController {
    static final String INVOICE_ENDPOINT= "/invoice";

    InvoiceManagement billingManager;

    @Autowired
    public BillingController(InvoiceManagement billingManager) {
        this.billingManager = billingManager;
    }

    @PostMapping(INVOICE_ENDPOINT)
    public CreateInvoiceResponse invoice(@RequestBody CreateInvoiceRequest req){
        return billingManager.createInvoice(req);
    }

    @GetMapping(INVOICE_ENDPOINT)
    public List<Invoice> getAll(){
        return billingManager.getAllInvoices();
    }

    @GetMapping(INVOICE_ENDPOINT+"/{id}")
    public Invoice invoice(@PathVariable Long id){
        return billingManager.getInvoice(id);
    }





}
