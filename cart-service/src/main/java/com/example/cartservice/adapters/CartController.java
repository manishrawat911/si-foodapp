package com.example.cartservice.adapters;

import com.example.cartservice.business.entites.Cart;
import com.example.cartservice.dto.*;
import com.example.cartservice.ports.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1", produces = "application/json")
public class CartController {

    private static final String ENDPOINT = "/cart/";

    private ICartService cartService;

    @Autowired
    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping (ENDPOINT)
    public Cart createCart(@RequestBody CartRequest cartRequest)
    {
        return cartService.createCart(cartRequest);
    }

    @GetMapping(ENDPOINT)
    public Cart addProducts(@RequestBody AddItemToCartRequest cartRequest)
    {
        return cartService.addItem(cartRequest);
    }

    @DeleteMapping (ENDPOINT+"{cartId}/{userId}/{itemId}/{quantity}")
    public Cart deleteItem(@PathVariable Long cartId, Long userId, Long itemId, int quantity)
    {
        return cartService.deleteItem(new DeleteItemFromCartRequest(cartId,userId,itemId,quantity));
    }

    @GetMapping(ENDPOINT+"{cartId}")
    public Cart getCart(@PathVariable Long cartId)
    {
        return cartService.getCart(new GetCartDetails(cartId));
    }

    @GetMapping("checkout/{cartId}/{userId}")
    public Cart checkOut(Long cartId,Long userId)
    {
        return cartService.checkout(new CheckOutCart(cartId,userId));
    }

}
