package com.example.cartservice.adapters;

import com.example.cartservice.business.CartService;
import com.example.cartservice.dto.AddItemToCartRequest;
import com.example.cartservice.dto.CartUpdated;
import com.example.cartservice.dto.DeleteItemFromCartRequest;
import com.example.cartservice.dto.UpdateItemInCart;
import com.example.cartservice.ports.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1", produces = "application/json")
public class CartController {

    private static final String ENDPOINT = "/cart";

    private ICartService cartService;

    @Autowired
    public CartController(ICartService cartService){
        this.cartService = cartService;
    }

    @GetMapping(ENDPOINT)
    public CartUpdated add(@RequestBody AddItemToCartRequest request){
        return cartService.addItem(request);
//        return "Hello from cart service";
    }

    @DeleteMapping(ENDPOINT)
    public CartUpdated delete(@RequestBody DeleteItemFromCartRequest request){
        return cartService.deleteItem(request);
    }

    @PatchMapping(ENDPOINT)
    public CartUpdated update(@RequestBody UpdateItemInCart request){
        return cartService.updateItem(request);
    }



    //add items to a user's cart

    //remove items from a user's cart

    //update items from a users' cart

    // get a cart for user
}
