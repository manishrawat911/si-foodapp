package com.example.billingservice.ports;

import com.example.billingservice.business.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

//    List<Invoice> getInvoicesByInvoiceNumber(Long id);

    Invoice getInvoiceByInvoiceId(Long id);
    Invoice getInvoiceByCartId(Long id);
    Invoice getInvoiceByPaymentReference(String ref);


}
