package com.example.productcatalogservice.business;

import com.example.productcatalogservice.business.entites.Product;
import com.example.productcatalogservice.dto.AddProductRequest;
import com.example.productcatalogservice.dto.DeleteProductRequest;
import com.example.productcatalogservice.ports.CatalogueRepository;
import com.example.productcatalogservice.ports.IProductService;
import com.example.productcatalogservice.dto.GetProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Objects;

@Service
public class ProductManager implements IProductService {

    private final CatalogueRepository catalogueRepository;

    @Autowired
    public ProductManager(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    @Override
    public Product getProduct(GetProductRequest request)
    {
        if (!Objects.isNull(request.getItemId()))
        {
            return catalogueRepository.findByProductId(request.getItemId());
        }
        return null;
    }

    @Override
    public Product getProducts() {
        return null;
    }

    public Product addProduct(AddProductRequest addProductRequest)
    {
        Product product = new Product(addProductRequest.getProductName(),addProductRequest.getProductDescription(),addProductRequest.getPrice(),addProductRequest.getProviderId());
        Product added = catalogueRepository.save(product);
        return added;
    }

    public void removeProduct(DeleteProductRequest deleteProductRequest)
    {
//        if (Objects.isNull(deleteProductRequest.getProviderId()))
//        {
            Product product = catalogueRepository.findByProductId(deleteProductRequest.getProductId());
            catalogueRepository.delete(product);
//        }
//        else {
//            Product product = catalogueRepository.findByProviderId(deleteProductRequest.getProductId(),deleteProductRequest.getProviderId());
//            catalogueRepository.delete(product);
//        }

    }

//    public void addProduct()
}
