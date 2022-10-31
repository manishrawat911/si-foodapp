package com.example.productcatalogservice.adapters;

import com.example.productcatalogservice.business.ProductManager;
import com.example.productcatalogservice.business.entites.Product;
import com.example.productcatalogservice.dto.AddProductRequest;
import com.example.productcatalogservice.dto.DeleteProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1", produces = "application/json")

public class CatalogueController {

    private static final String ENDPOINT="/catalogue";
    private final ProductManager productManager;

    @Autowired
    public CatalogueController(ProductManager productManager)
    {
        this.productManager = productManager;
    }

    @GetMapping(ENDPOINT)
    public List<Product> findAll() {
        return productManager.getProducts();
    }
    @RequestMapping(value = ENDPOINT+"/{productId}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable Long productId)
    {
        return productManager.getProduct(productId);
    }

    @PostMapping(ENDPOINT)
    public Product add(@RequestBody AddProductRequest addProductRequest)
    {
        return productManager.addProduct(addProductRequest);
    }

    @DeleteMapping(ENDPOINT+"{id}")
    public void delete(@RequestBody DeleteProductRequest deleteProductRequest,@PathVariable Long id)
    {
        if (!deleteProductRequest.getProductId().equals(id))
        {
            throw new IllegalArgumentException("Wrong Identity Number");
        }
        productManager.removeProduct(deleteProductRequest);
    }

}
