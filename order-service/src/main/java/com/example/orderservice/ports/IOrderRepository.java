package com.example.orderservice.ports;

import com.example.orderservice.business.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {
//    @Override
    List<Order> findAll();
}
