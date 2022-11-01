package com.example.productcatalogservice.business;

import com.example.productcatalogservice.business.entites.Goodies;
import com.example.productcatalogservice.dto.AddGoodiesRequest;
import com.example.productcatalogservice.dto.DeleteGoodiesRequest;
import com.example.productcatalogservice.ports.GoodiesRepository;
import com.example.productcatalogservice.ports.IGoodiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodiesManager implements IGoodiesService {

    GoodiesRepository goodiesRepository;

    @Autowired
    public GoodiesManager(GoodiesRepository goodiesRepository)
    {
        this.goodiesRepository = goodiesRepository;
    }

    @Override
    public Goodies getGoodies(Long goodieId) {
        Goodies goodies = goodiesRepository.findByGoodiesId(goodieId);
        if (!goodies.getGoodieName().isEmpty())
        {
            return goodiesRepository.findByGoodiesId(goodieId);
        }
        return null;
    }

    @Override
    public List<Goodies> getGoodies() {
        return goodiesRepository.findAll();
    }

    @Override
    public Goodies addGoodies(AddGoodiesRequest addGoodiesRequest) {
        Goodies goodies = new Goodies(addGoodiesRequest.getGoodieName(),addGoodiesRequest.getMddPoint());
        Goodies added = goodiesRepository.save(goodies);
        return added;
    }

    @Override
    public void removeGoodies(DeleteGoodiesRequest deleteGoodiesRequest) {
        Goodies goodies = goodiesRepository.findByGoodiesId(deleteGoodiesRequest.getGoodiesId());
        goodiesRepository.delete(goodies);
    }
}
