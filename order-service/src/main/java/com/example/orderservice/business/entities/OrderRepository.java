package com.example.orderservice.business.entities;

import com.example.orderservice.ports.IOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderId(Long id);

    @Transactional
    @Modifying
    @Query("update D_Orders d set d.status = ?1 where d.orderId = ?2")
    int updateOrderStatusById(String status, Long orderId);
}
