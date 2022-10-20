package com.example.cartservice.ports;

import com.example.cartservice.dto.AddItemToCartRequest;
import com.example.cartservice.dto.CartUpdated;
import com.example.cartservice.dto.DeleteItemFromCartRequest;
import com.example.cartservice.dto.UpdateItemInCart;

public interface ICartService {

    CartUpdated addItem(AddItemToCartRequest request);
    CartUpdated deleteItem(DeleteItemFromCartRequest request);
    CartUpdated updateItem(UpdateItemInCart request);
}
