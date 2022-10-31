package com.example.orderservice.business;

import com.example.orderservice.business.entities.Order;
import com.example.orderservice.business.entities.OrderRepository;
import com.example.orderservice.dto.CreateOrderCommand;
import com.example.orderservice.dto.UpdateOrderStatusCommand;
import com.example.orderservice.ports.IOrderRepository;
import com.example.orderservice.ports.OrderManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManager implements OrderManagement {

    OrderRepository orderRepository;

    @Autowired
    public OrderManager(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public void createOrder(CreateOrderCommand command) {
        Order newOrder =  new Order();
        newOrder.setInvoiceId(command.getInvoiceId());
        newOrder.setCartId(command.getCartId());
        newOrder.setStatus("RECEIVED");
        orderRepository.save(newOrder);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findByOrderId(id);
    }

    @Override
    public Order updateOrderStatus(UpdateOrderStatusCommand command) {
        orderRepository.updateOrderStatusById(command.getStatus(), command.getOrderId());
        return getOrderById(command.getOrderId());
//        return null;
    }
}
