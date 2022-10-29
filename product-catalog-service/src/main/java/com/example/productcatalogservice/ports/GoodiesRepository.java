package com.example.productcatalogservice.ports;

import com.example.productcatalogservice.business.entites.Goodies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodiesRepository extends JpaRepository<Goodies,Long> {
    Goodies findByGoodiesId(Long goodieId);
}
