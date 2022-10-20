package com.example.cartservice.business;

import com.example.cartservice.dto.AddItemToCartRequest;
import com.example.cartservice.dto.CartUpdated;
import com.example.cartservice.dto.DeleteItemFromCartRequest;
import com.example.cartservice.dto.UpdateItemInCart;
import com.example.cartservice.ports.ICartService;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {

    public CartUpdated addItem(AddItemToCartRequest request){
        //fetch product details from product validator object and add into items map with qty in request <Product,qty>
        return null;
    }
    public CartUpdated deleteItem(DeleteItemFromCartRequest request){
        //fetch product details from product validator object and remove from cart -> items.remove(product)
        return null;
    }
    public CartUpdated updateItem(UpdateItemInCart request){
        return null;
        //fetch product details from product validator object. Update can be made using replace method using old and new values in the request
    }
}
