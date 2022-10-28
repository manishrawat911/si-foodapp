package com.example.productcatalogservice.business;

import com.example.productcatalogservice.business.entites.Product;
import com.example.productcatalogservice.ports.IProductService;
import com.example.productcatalogservice.dto.GetProductRequest;

public class ProductManager implements IProductService {
    @Override
    public Product getProduct(GetProductRequest request) {
        return null;
    }

    @Override
    public Product getProducts() {
        return null;
    }

    public boolean addProduct(String productName, String productDescription, Float price)
    {
        Product product = new Product();
        return true;
    }

    public boolean removeProduct(Long productId)
    {
        return true;
    }

//    public void addProduct()
}
