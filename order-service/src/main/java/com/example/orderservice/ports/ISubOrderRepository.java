package com.example.orderservice.ports;

import com.example.orderservice.business.entities.SubOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubOrderRepository extends JpaRepository<SubOrder, Long> {
}
