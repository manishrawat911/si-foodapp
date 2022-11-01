package com.example.cartservice.adapters;

import com.example.cartservice.business.CartService;
import com.example.cartservice.business.entites.Product;
import com.example.cartservice.dto.GetItemDetails;
import com.example.cartservice.ports.IProductValidator;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Objects;
import java.util.Random;

@Controller
public class ProductValidatorClient implements IProductValidator {

    Logger logger = LoggerFactory.getLogger(ProductValidatorClient.class);
    private static final String APP_NAME = "ProductCatalogService";
    private static final String ENDPOINT = "/catalogue";
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    public ProductValidatorClient(EurekaClient eurekaClient)
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
        if (Objects.isNull(candidates)) { // no email service in the registry
            throw new IllegalStateException();
        }
        Random rand = new Random();
        InstanceInfo infos = // Randomly picking one email service among candidates
                candidates.getInstances().get(rand.nextInt(candidates.size()));
        return "http://"+infos.getIPAddr()+":"+infos.getPort()+"/v1/";
    }

}
