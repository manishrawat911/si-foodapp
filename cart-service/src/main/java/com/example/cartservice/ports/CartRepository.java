package com.example.cartservice.ports;

import com.example.cartservice.business.entites.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {

}
