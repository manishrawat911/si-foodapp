package com.example.cartservice.ports;

import com.example.cartservice.business.entites.Cart;
import com.example.cartservice.business.entites.Product;
import com.example.cartservice.dto.*;

import java.util.zip.CheckedOutputStream;

public interface ICartService {

    public Cart createCart(CartRequest cartRequest);
    Cart addItem(AddItemToCartRequest cartRequest);
    Cart deleteItem(DeleteItemFromCartRequest request);
    Cart checkout(CheckOutCart request);

    Cart getCart(GetCartDetails getCartDetails);
    Product getProduct(GetItemDetails getItemDetails);
}
