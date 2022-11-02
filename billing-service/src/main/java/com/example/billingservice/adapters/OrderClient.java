package com.example.billingservice.adapters;

import com.example.billingservice.dto.CreateOrderRequest;
import com.example.billingservice.dto.CreateOrderResponse;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import java.util.Objects;
import java.util.Random;

@Service
public class OrderClient {

    private static final String ORDER_SERVICE_NAME = "ORDERSERVICE";
    private static final String ENDPOINT = "/order";
    private static final String HTTP = "http://";

    private final EurekaClient registry;

    @Autowired
    public OrderClient(EurekaClient registry) {
        this.registry = registry;
    }

    public CreateOrderResponse send(CreateOrderRequest req){
        CreateOrderResponse response = new CreateOrderResponse();
        try{
            WebClient webClient = buildWebClient();
            response = webClient.post()
                    .uri(ENDPOINT)
                    .body(BodyInserters.fromValue(req))
                    .retrieve()
                    .bodyToMono(CreateOrderResponse.class)
                    .block();
        }
        catch (IllegalArgumentException ex){
            //log exception
        }
        catch (WebClientException ex){
            // log exception related to web client
        }
        return response;
    }

    public WebClient buildWebClient(){
        String url = locateExternalService();
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    private String locateExternalService(){
        Application candidates = registry.getApplication(ORDER_SERVICE_NAME);
        if(Objects.isNull(candidates)){
            throw new IllegalStateException();
        }

        Random rand = new Random();
        InstanceInfo infos = candidates.getInstances().get(rand.nextInt(candidates.size()));
        return HTTP+infos.getIPAddr()+":"+infos.getPort();
    }
}
