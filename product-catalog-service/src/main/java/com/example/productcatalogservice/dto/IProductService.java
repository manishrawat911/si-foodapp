package com.example.productcatalogservice.dto;

import com.example.productcatalogservice.business.entites.Product;
import com.example.productcatalogservice.ports.GetProductRequest;

public interface IProductService {

    Product getProduct(GetProductRequest request);
    Product getProducts();
    boolean addProduct(String productName, String productDescription, Float price);
    boolean removeProduct(Long productId);
//    Product getProduct();
}
