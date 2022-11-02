package com.example.orderservice.business;

import com.example.orderservice.business.entities.Order;
import com.example.orderservice.business.entities.OrderRepository;
import com.example.orderservice.dto.CreateOrderCommand;
import com.example.orderservice.dto.CreateOrderResponse;
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
    public CreateOrderResponse createOrder(CreateOrderCommand command) {
        CreateOrderResponse response = new CreateOrderResponse();
        try{
            Order newOrder = new Order();
            newOrder.setInvoiceId(command.getInvoiceId());
            newOrder.setCartId(command.getCartId());
            newOrder.setStatus("RECEIVED");
            Order o = orderRepository.save(newOrder);
            response.setOrderId(o.getOrderId());
            response.setStatus("RECEIVED");

        }
        catch (Exception ex){
            response.setStatus("ERROR");
        }
        return response;
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
