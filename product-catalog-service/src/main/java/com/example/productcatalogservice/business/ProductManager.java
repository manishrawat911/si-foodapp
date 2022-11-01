package com.example.productcatalogservice.business;

import com.example.productcatalogservice.business.entites.Product;
import com.example.productcatalogservice.dto.AddProductRequest;
import com.example.productcatalogservice.dto.DeleteProductRequest;
import com.example.productcatalogservice.ports.CatalogueRepository;
import com.example.productcatalogservice.ports.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements IProductService {

    private final CatalogueRepository catalogueRepository;

    @Autowired
    public ProductManager(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    @Override
    public Product getProduct(Long request)
    {
        Product product = catalogueRepository.findByProductId(request);
        if (!product.getProductName().isEmpty())
        {
            return catalogueRepository.findByProductId(request);
        }
        return null;
    }

    @Override
    public List<Product> getProducts()
    {
        return catalogueRepository.findAll();
    }

    public Product addProduct(AddProductRequest addProductRequest)
    {
        Product product = new Product(addProductRequest.getProductName(),addProductRequest.getProductDescription(),addProductRequest.getPrice(),addProductRequest.getProviderId());
        Product added = catalogueRepository.save(product);
        return added;
    }

    public void removeProduct(DeleteProductRequest deleteProductRequest)
    {

            Product product = catalogueRepository.findByProductId(deleteProductRequest.getProductId());
            catalogueRepository.delete(product);


    }

}
