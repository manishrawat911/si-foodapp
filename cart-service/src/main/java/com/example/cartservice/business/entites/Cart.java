package com.example.cartservice.business.entites;

import javax.persistence.Id;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cart {
    @Id
    String cartId;
    public Map<Product, Integer> items;
    Float value;

    CartStatus status;
    public enum CartStatus {
        INPROGRESS,
        EXECUTED,
        READYTODELETE
    }

}
