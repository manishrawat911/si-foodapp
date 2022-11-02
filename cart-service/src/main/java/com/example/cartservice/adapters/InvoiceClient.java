package com.example.cartservice.adapters;

import com.example.cartservice.business.entites.Cart;
import com.example.cartservice.dto.InvoiceResponse;
import com.example.cartservice.ports.IInvoiceService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Objects;
import java.util.Random;

@Controller
@Slf4j
public class InvoiceClient implements IInvoiceService {

    private static final String APP_NAME = "BillingService";
    private static final String ENDPOINT = "/invoice";
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    public InvoiceClient(EurekaClient eurekaClient)
    {
        this.eurekaClient = eurekaClient;
    }

    @Override
    public void sendInvoice(Cart cart) {
        WebClient webClient = buildClient();
        InvoiceResponse invoiceResponse = webClient.post().uri(ENDPOINT).body(BodyInserters.fromValue(cart)).retrieve().bodyToMono(InvoiceResponse.class).block();
        log.info("Response..."+invoiceResponse);
        log.info("Response Sent");
    }

    private WebClient buildClient() {
        String url = locateExternalService();
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    private String locateExternalService() {
        Application candidates = eurekaClient.getApplication(APP_NAME);
        if (Objects.isNull(candidates)) { 
            throw new IllegalStateException();
        }
        Random rand = new Random();
        InstanceInfo infos = candidates.getInstances().get(rand.nextInt(candidates.size()));
        return "http://"+infos.getIPAddr()+":"+infos.getPort()+"/v1/";
    }
}
