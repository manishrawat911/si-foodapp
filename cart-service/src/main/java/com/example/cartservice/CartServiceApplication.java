package com.example.cartservice;


import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class CartServiceApplication {


    @Autowired
    private EurekaClient eurekaClient;
    public static void main(String[] args) {
        SpringApplication.run(CartServiceApplication.class, args);
    }

}
