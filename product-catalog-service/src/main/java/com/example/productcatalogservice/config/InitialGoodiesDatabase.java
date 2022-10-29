package com.example.productcatalogservice.config;

import com.example.productcatalogservice.business.entites.Goodies;
import com.example.productcatalogservice.ports.GoodiesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class InitialGoodiesDatabase {

    @Bean
    CommandLineRunner initDatabase(GoodiesRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Goodies("Book",Float.valueOf(12))));
            log.info("Preloading " + repository.save(new Goodies("Folder",Float.valueOf(5))));
        };
    }

}
