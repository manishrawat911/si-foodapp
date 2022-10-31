package com.example.orderservice.ports;

import com.example.orderservice.business.entities.Order;
import com.example.orderservice.dto.CreateOrderCommand;
import com.example.orderservice.dto.UpdateOrderStatusCommand;

import java.util.List;

public interface OrderManagement {

//    Write or Create Operations
    void createOrder(CreateOrderCommand command);

    //Reads
    List<Order> getAllOrders();
    Order getOrderById(Long id);

//    Order getOrdersForUser(Long userId);
//    List<Order> getOrdersForProvider(Long providerId); //suborder table will be user to provide the data for a provider

//    //Updates
    Order updateOrderStatus(UpdateOrderStatusCommand command);
//    void updateSubOrderStatus(Long subOrderId, String status);
//

}
