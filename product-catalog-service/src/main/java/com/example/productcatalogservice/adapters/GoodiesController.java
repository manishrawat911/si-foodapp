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

    private static final String ENDPOINT="/catalogue/goodies/";
    private final GoodiesManager goodiesManager;

    @Autowired
    public GoodiesController(GoodiesManager goodiesManager)
    {
        this.goodiesManager = goodiesManager;
    }

    @GetMapping(ENDPOINT)
    public List<Goodies> findAll() {
        return goodiesManager.getGoodies();
    }

    @GetMapping(ENDPOINT+"/{id}")
    public Goodies getGoodies(@PathVariable Long goodieId)
    {
        return goodiesManager.getGoodies(goodieId);
    }

    @PostMapping(ENDPOINT)
    public Goodies add(@RequestBody AddGoodiesRequest addGoodiesRequest)
    {
        return goodiesManager.addGoodies(addGoodiesRequest);
    }

    @DeleteMapping(ENDPOINT+"/{id}")
    public void delete(@RequestBody DeleteGoodiesRequest deleteGoodiesRequest, @PathVariable Long id)
    {
        if (!deleteGoodiesRequest.getGoodiesId().equals(id))
        {
            throw new IllegalArgumentException("Wrong Identity Number");
        }
        goodiesManager.removeGoodies(deleteGoodiesRequest);
    }


}
