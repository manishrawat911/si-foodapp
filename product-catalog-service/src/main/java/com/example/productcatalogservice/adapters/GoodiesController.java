package com.example.productcatalogservice.adapters;

import com.example.productcatalogservice.business.GoodiesManager;
import com.example.productcatalogservice.business.entites.Goodies;
import com.example.productcatalogservice.dto.AddGoodiesRequest;
import com.example.productcatalogservice.dto.DeleteGoodiesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1", produces = "application/json")
public class GoodiesController {

    private static final String ENDPOINT_GOODIES="/catalogue/goodies/";
    private final GoodiesManager goodiesManager;

    @Autowired
    public GoodiesController(GoodiesManager goodiesManager)
    {
        this.goodiesManager = goodiesManager;
    }

    @GetMapping(ENDPOINT_GOODIES)
    public List<Goodies> findAll() {
        return goodiesManager.getGoodies();
    }

    @GetMapping(ENDPOINT_GOODIES+"/{id}")
    public Goodies getGoodies(@PathVariable Long goodieId)
    {
        return goodiesManager.getGoodies(goodieId);
    }

    @PostMapping(ENDPOINT_GOODIES)
    public Goodies add(@RequestBody AddGoodiesRequest addGoodiesRequest)
    {
        return goodiesManager.addGoodies(addGoodiesRequest);
    }

    @DeleteMapping(ENDPOINT_GOODIES+"/{id}")
    public void delete(@RequestBody DeleteGoodiesRequest deleteGoodiesRequest, @PathVariable Long id)
    {
        if (!deleteGoodiesRequest.getGoodiesId().equals(id))
        {
            throw new IllegalArgumentException("Wrong Identity Number");
        }
        goodiesManager.removeGoodies(deleteGoodiesRequest);
    }


}
