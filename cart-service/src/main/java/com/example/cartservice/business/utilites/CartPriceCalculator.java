package com.example.cartservice.business.utilites;

import com.example.cartservice.business.entites.Cart;
import com.example.cartservice.business.entites.Product;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CartPriceCalculator {

    static Float calculateTotal(Cart cart){
        Float total = 0.0f;

//        Map<Product, Integer>  items =  cart.items;
        Set<Product> allItems = cart.items.keySet();
        Iterator<Product> itr = allItems.iterator();

        while(itr.hasNext()){
            Product p = itr.next();
            total += p.price * cart.items.get(p);
        }

        // tax can be calculated before returning total
        return total;
    }
}
