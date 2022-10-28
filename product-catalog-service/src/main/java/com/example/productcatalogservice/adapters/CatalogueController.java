package com.example.productcatalogservice.adapters;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1", produces = "application/json")

public class CatalogueController {

    private static final String ENDPOINT="/catalogue";

}
