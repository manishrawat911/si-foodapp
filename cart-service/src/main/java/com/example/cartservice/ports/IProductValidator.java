package com.example.cartservice.ports;

import com.example.cartservice.business.entites.Product;
import com.example.cartservice.dto.GetItemDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

public interface IProductValidator {
    Product getProduct(Long id);
}
