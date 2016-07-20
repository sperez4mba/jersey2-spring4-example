package com.underdog.jersey.spring.example.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/greeting")
public interface GreetingResource {
    @GET
    Response getGreeting(@QueryParam("name") String name);
}
