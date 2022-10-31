package com.example.cartservice.business;

import com.example.cartservice.adapters.ProductValidatorClient;
import com.example.cartservice.business.entites.Cart;
import com.example.cartservice.business.entites.Product;
import com.example.cartservice.dto.*;
import com.example.cartservice.ports.CartItemRepository;
import com.example.cartservice.ports.CartRepository;
import com.example.cartservice.ports.ICartService;
import com.example.cartservice.ports.IProductValidator;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService implements ICartService {

    private Map<Long,Cart> carts = new HashMap<>();
    //private Map<Long, Product> products = new HashMap<>();

    private List<Product> products;

    Logger logger = LoggerFactory.getLogger(CartService.class);

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductValidatorClient productValidatorClient;
    @Autowired
    public CartService(CartRepository cartRepository,ProductValidatorClient productValidatorClient,CartItemRepository cartItemRepository)
    {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productValidatorClient = productValidatorClient;
    }

    @Override
    public Cart createCart(CartRequest cartRequest) {
        logger.info("Details......"+cartRepository.findById(cartRequest.getCartId()).isEmpty());
        if (cartRepository.findById(cartRequest.getCartId()).isEmpty())
        {
            Cart cart = new Cart(cartRequest.getCartId(),cartRequest.getUserId());
            cart.setStatus(Cart.CartStatus.CREATED);
            cart.setTotalvalue(Float.valueOf(0));
            cartRepository.save(cart);
            products = new ArrayList<>();
            return cart;
        }

        Cart cart = cartRepository.findByCartId(cartRequest.getCartId());
        calculatePrice(cart);
        //carts.put(cartRequest.getCartId(),cart);
        cartRepository.save(cart);
        return cart;
    }

    private void calculatePrice(Cart cart) {
        if (cart!=null)
        {
            if (cart.getList_product()!=null && cart.getList_product().size()>0)
            {
                for (Product product : cart.getList_product())
                {
                    logger.info("TOTal Price.."+cart.getTotalvalue());
                    cart.setTotalvalue(cart.getTotalvalue()+product.getPrice()*product.getQuantity());
                }
            }
        }
        cartRepository.save(cart);
    }


    @Override
    public Cart addItem(AddItemToCartRequest cartRequest) {
        CartRequest cR = new CartRequest(cartRequest.getCartid(),cartRequest.getUserId());
        Cart cart = createCart(cR);
        Product product = getProduct(new GetItemDetails(cartRequest.getItemId()));

        if (product!=null)
        {

            cart.addCartItem(product);
            cart.setTotalQuantity(cart.getTotalQuantity() + cartRequest.getQuantity());
            product.setQuantity(cartRequest.getQuantity());
            product.setCartId(cartRequest.getCartid());
            cartItemRepository.save(product);
            calculatePrice(cart);
            cart.setStatus(Cart.CartStatus.ADDED);
//            products.add(product);
//            cart.setList_product(products);
            cartRepository.save(cart);
        }

        if (product==null)
        {
            return null;
        }
        cartRepository.save(cart);

        return cart;


    }

    @Override
    public Cart deleteItem(DeleteItemFromCartRequest request) {
        List<Product> listOfItemToRemove = new ArrayList<>();
        Cart cart = createCart(new CartRequest(request.getCartId(),request.getUserId()));
        cart.getList_product().stream().filter(items -> items.getProductId().equals(request.getItemId()))
                .forEach(items -> {
                    if (request.getQuantity() >= items.getQuantity()){
                        listOfItemToRemove.add(items);
                    }
                    else {
                        items.setQuantity(items.getQuantity() - request.getQuantity());
                    }
                });

        listOfItemToRemove.forEach(cart::removeCartItem);
        cart.getProductIds().remove(listOfItemToRemove);
        cartRepository.delete(cart);
        calculatePrice(cart);
        carts.put(request.getCartId(),cart);
        return null;
    }

    @Override
    public Cart checkout(CheckOutCart request) {
        Cart cart = getCart(new GetCartDetails(request.getCartId()));
        calculatePrice(cart);
        cart.setStatus(Cart.CartStatus.READYTODELETE);
        return cart;
    }

    @Override
    public Cart getCart(GetCartDetails getCartDetails) {
        Cart cart1 = cartRepository.findById(getCartDetails.getCartId()).get();
        List<Product> productList = new ArrayList<>();
        for (Long items: cart1.getProductIds()) {
            productList.add(cartItemRepository.findByProductId(items));
        }
        cart1.setList_product(productList);
        logger.info("sizeeee......"+cart1.getList_product().size());
        return cart1;
    }

    @Override
    public Product getProduct(GetItemDetails getItemDetails) {
        return productValidatorClient.getProduct(getItemDetails.getProductId());
    }
}
