package com.example.productcatalogservice.ports;

import com.example.productcatalogservice.business.entites.Product;
import com.example.productcatalogservice.dto.AddProductRequest;
import com.example.productcatalogservice.dto.DeleteProductRequest;
import com.example.productcatalogservice.dto.GetProductRequest;


public interface IProductService {

    Product getProduct(GetProductRequest request);
    Product getProducts();
    Product addProduct(AddProductRequest addProductRequest);
    void removeProduct(DeleteProductRequest deleteProductRequest);
//    Product getProduct();
}
