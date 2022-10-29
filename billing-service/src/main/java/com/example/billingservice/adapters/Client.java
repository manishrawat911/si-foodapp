package com.example.billingservice.adapters;

import javax.ws.rs.*;

@Path("/hello-world")
public interface Client {
    @GET
    @Produces("text/plain")
    String hello(@QueryParam("name") String name);
}