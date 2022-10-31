package com.example.cartservice.business.entites;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@NoArgsConstructor
@Getter @Setter
@Entity
public class Cart {
    @Id
    Long cartId;
    private @NonNull Long userId;
    Float totalvalue;
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
