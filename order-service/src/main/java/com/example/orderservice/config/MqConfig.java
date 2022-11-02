package com.example.orderservice.config;

public class MqConfig {

    public static final String DELIVERY_EXCHANGE_NAME = "delivery.exchange";
    public static final String DELIVERY_NEW_ORDER_ROUTING_KEY = "delivery.order.new";


    public static final String ORDER_EXCHANGE_NAME = "order.exchange";
    public static final String ORDER_STATUS_QUEUE = "order.queue.status";
    public static final String ORDER_STATUS_ROUTING_KEY = "order.status.update";


}
