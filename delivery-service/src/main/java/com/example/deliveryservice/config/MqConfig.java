package com.example.deliveryservice.config;

public class MqConfig {

//    own
    public static final String DELIVERY_EXCHANGE_NAME = "delivery.exchange";
    public static final String DELIVERY_NEW_ORDER_QUEUE = "delivery.queue";
    public static final String DELIVERY_NEW_ORDER_ROUTING_KEY = "delivery.order.new";

    // produces on
    public static final String ORDER_EXCHANGE_NAME = "order.exchange";
//    public static final String DELIVERY_NEW_ORDER_QUEUE = "delivery.queue";
    public static final String ORDER_STATUS_ROUTING_KEY = "order.status.update";

}
