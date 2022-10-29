package com.example.productcatalogservice.ports;

import com.example.productcatalogservice.business.entites.Goodies;
import com.example.productcatalogservice.dto.AddGoodiesRequest;
import com.example.productcatalogservice.dto.DeleteGoodiesRequest;

import java.util.List;

public interface IGoodiesService {

    Goodies getGoodies(Long goodieId);
    List<Goodies> getGoodies();
    Goodies addGoodies(AddGoodiesRequest addGoodiesRequest);
    void removeGoodies(DeleteGoodiesRequest deleteGoodiesRequest);

}
