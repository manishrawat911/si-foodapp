package com.example.cartservice.adapters;

import com.example.cartservice.business.entites.Product;
import com.example.cartservice.ports.IProductValidator;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;
import java.util.Random;

@Controller
public class ProductClient implements IProductValidator {

    private static final String APP_NAME = "ProductCatalogService";
    private static final String ENDPOINT = "/catalogue";
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    public ProductClient(EurekaClient eurekaClient)
    {
        this.eurekaClient = eurekaClient;
    }

    @Override
    public Product getProduct(Long id) {
        WebClient webClient = buildClient();
        Product product = webClient.get().uri(ENDPOINT+"/"+id).retrieve().bodyToMono(Product.class).block();
        return  product;
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
