package com.example.cartservice.business;

import com.example.cartservice.adapters.ProductValidatorClient;
import com.example.cartservice.business.entites.Cart;
import com.example.cartservice.business.entites.Product;
import com.example.cartservice.dto.*;
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
    private Map<Long, Product> products = new HashMap<>();

    Logger logger = LoggerFactory.getLogger(CartService.class);

    private final CartRepository cartRepository;
    private final ProductValidatorClient productValidatorClient;
    @Autowired
    public CartService(CartRepository cartRepository,ProductValidatorClient productValidatorClient)
    {
        this.cartRepository = cartRepository;
        this.productValidatorClient = productValidatorClient;
    }

    @Override
    public Cart createCart(CartRequest cartRequest) {
        if (cartRepository.findByCartId(cartRequest.getCartId()) == null)
        {
            Cart cart = new Cart(cartRequest.getCartId(),cartRequest.getUserId());
            logger.info("It's enter to the cart creation");
            //carts.put(cartRequest.getCartId(),cart);
            return cart;
        }
        logger.info("It's not enter to the cart creation");
        Cart cart = carts.get(cartRequest.getCartId());
        calculatePrice(cart);
        carts.put(cartRequest.getCartId(),cart);
        cartRepository.save(cart);
        return null;
    }

    private void calculatePrice(Cart cart) {
        if (cart!=null)
        {
            if (cart.getList_product()!=null && cart.getList_product().size()>0)
            {
                for (Product product : cart.getList_product())
                {
                    cart.setTotalvalue(cart.getTotalvalue()+product.getPrice()*product.getQuantity());
                }
            }
        }
        cartRepository.save(cart);
    }


    @Override
    public Cart addItem(AddItemToCartRequest cartRequest) {
        CartRequest cR = new CartRequest(cartRequest.getCartid(),cartRequest.getUserId());
        logger.info("Check 0");
        Cart cart = createCart(cR);
        logger.info("Check 1");
        GetItemDetails getItemDetails = new GetItemDetails(cartRequest.getItemId());
        logger.info("Check 2");
        Product product = getProduct(getItemDetails);
        logger.info("Check 3");

        if (product!=null)
        {
            cart.addCartItem(product);
            calculatePrice(cart);
            cart.setList_product(dedupeCartItems(cart));
        }
        //carts.put(cartRequest.getCartid(),cart);
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
        cartRepository.delete(cart);
        calculatePrice(cart);
        carts.put(request.getCartId(),cart);
        return null;
    }

    @Override
    public Cart checkout(CheckOutCart request) {
        Cart cart = createCart(new CartRequest(request.getCartId(),request.getUserId()));
        cart.resetCartItemList();
        calculatePrice(cart);
        carts.put(request.getCartId(),cart);
        return cart;
    }

    @Override
    public Product getProduct(GetItemDetails getItemDetails) {
        return productValidatorClient.getProduct(getItemDetails.getProductId());
    }

    private List<Product> dedupeCartItems(Cart sc) {
        List<Product> result = new ArrayList<>();
        Map<Long, Integer> quantityMap = new HashMap<>();
        for (Product sci : sc.getList_product()) {
            if (quantityMap.containsKey(sci.getProductId())) {
                quantityMap.put(sci.getProductId(), quantityMap.get(sci.getProductId()) + sci.getQuantity());
            } else {
                quantityMap.put(sci.getProductId(), sci.getQuantity());
            }
        }

        for (Long itemId : quantityMap.keySet()) {
            Product p = getProduct(new GetItemDetails(itemId));
            Product newItem = new Product();
            newItem.setQuantity(quantityMap.get(itemId));
            newItem.setPrice(p.getPrice());
            newItem.setProviderId(p.getProviderId());
            newItem.setProductName(p.getProductName());
            newItem.setProductId(p.getProductId());
            result.add(newItem);
        }

        return result;
    }
}
