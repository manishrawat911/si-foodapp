package com.example.cartservice.business.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;


@NoArgsConstructor
@Getter @Setter
@Entity
@JsonIgnoreProperties({"productIds"})
public class Cart {
    @Id
    @Column(name = "cartId")
    Long cartId;
    private @NonNull Long userId;
    Float totalvalue;

    @ElementCollection
    List<Long> productIds = new ArrayList<Long>();
    private @Id @GeneratedValue Long cartId;

   // public Map<Product, Integer> items;
   // Float value;

    CartStatus status;

    @OneToMany(mappedBy = "cart")
    private List<Product> list_product = new ArrayList<>();

//    @OneToMany(mappedBy = "cart")
//    List<Product> list_product;

    @NonNull int totalQuantity;


    public Cart(Long cartid, Long userId)
    {
        this.cartId = cartid;
        this.userId = userId;
    }

    public void setList_product(List<Product> list_product) {
        this.list_product = list_product;
    }



    public void addCartItem(Product product) {
        if (product != null) {
            productIds.add(product.getProductId());
            list_product.add(product);
        }
    }

    public boolean removeCartItem(Product product) {
        boolean removed = false;
        if (product != null) {
            removed = list_product.remove(product);
        }
        return removed;
    }

    public void resetCartItemList() {
        list_product = new ArrayList<Product>();
    }

    public enum CartStatus {
        CREATED,
        ADDED,
        EXECUTED,
        READYTODELETE
    }

}
