package com.example.productcatalogservice.dto;

import com.example.productcatalogservice.business.entites.Product;
import com.example.productcatalogservice.ports.GetProductRequest;

public interface IProductService {

    Product getProduct(GetProductRequest request);
    Product getProducts();
//    Product getProduct();
}
