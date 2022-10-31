package com.example.cartservice.ports;

import com.example.cartservice.business.entites.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    List<Cart> findByUserId(Long userId);

    Cart findByCartId(Long cartId);

public interface CartRepository extends JpaRepository<Cart, String> {

}
