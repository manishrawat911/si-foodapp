package com.example.productcatalogservice.ports;

import com.example.productcatalogservice.business.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueRepository extends JpaRepository<Product,Long> {

    Product findByProductId(Long productId);
}
