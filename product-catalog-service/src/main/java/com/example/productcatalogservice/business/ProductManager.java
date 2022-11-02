package com.example.productcatalogservice.business;

import com.example.productcatalogservice.business.entites.Product;
import com.example.productcatalogservice.dto.AddProductRequest;
import com.example.productcatalogservice.dto.DeleteProductRequest;
import com.example.productcatalogservice.ports.ProductRepository;
import com.example.productcatalogservice.ports.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Long request)
    {
        Product product = productRepository.findByProductId(request);
        if (!product.getProductName().isEmpty())
        {
            return productRepository.findByProductId(request);
        }
        return null;
    }

    @Override
    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }

    public Product addProduct(AddProductRequest addProductRequest)
    {
        Product product = new Product(addProductRequest.getProductName(),addProductRequest.getProductDescription(),addProductRequest.getPrice(),addProductRequest.getProviderId());
        Product added = productRepository.save(product);
        return added;
    }

    public void removeProduct(DeleteProductRequest deleteProductRequest)
    {

            Product product = productRepository.findByProductId(deleteProductRequest.getProductId());
            productRepository.delete(product);


    }

}
