package com.example.productcatalogservice.config;

import com.example.productcatalogservice.business.entites.Product;
import com.example.productcatalogservice.ports.CatalogueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InitialDatabase {

    @Bean
    CommandLineRunner initDatabase(CatalogueRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Product("Burger","Large Chicken Burger",Float.valueOf(12),Long.valueOf(0001))));
            log.info("Preloading " + repository.save(new Product("Coke","100 ml bottle",Float.valueOf(5),Long.valueOf(0002))));
        };
    }


}
