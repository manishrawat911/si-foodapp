package com.example.orderservice.business.adapters;

import com.example.orderservice.business.entities.Order;
import com.example.orderservice.dto.CreateOrderCommand;
import com.example.orderservice.dto.CreateOrderResponse;
import com.example.orderservice.dto.UpdateOrderStatusCommand;
import com.example.orderservice.ports.OrderManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1", produces = "application/json")
public class OrderController {

    private static final String ORDERS_ENDPOINT = "/order";
    OrderManagement orderManagementService;

    @Autowired
    public OrderController(OrderManagement orderManagementService) {
        this.orderManagementService = orderManagementService;
    }

    @GetMapping(ORDERS_ENDPOINT+"/{id}")
    public Order getOrderById(@PathVariable Long id){
        return  orderManagementService.getOrderById(id);
    }

    @GetMapping(ORDERS_ENDPOINT)
    public List<Order> getAllOrders(){
        return orderManagementService.getAllOrders();
    }

    @PostMapping(ORDERS_ENDPOINT)
    public CreateOrderResponse createOrder(@RequestBody CreateOrderCommand command){
        return orderManagementService.createOrder(command);
    }

    @PatchMapping(ORDERS_ENDPOINT)
    public Order updateOrderStatus(@RequestBody UpdateOrderStatusCommand command){
        return orderManagementService.updateOrderStatus(command);
    }

}
