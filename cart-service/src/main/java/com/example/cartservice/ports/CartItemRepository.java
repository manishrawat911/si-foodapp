package com.example.cartservice.ports;

import com.example.cartservice.business.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<Product, Long> {

    List<Product> findByCartId(Long cartId);
    Product findByProductId(Long productId);

}
