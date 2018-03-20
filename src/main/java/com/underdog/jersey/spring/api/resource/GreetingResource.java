package com.underdog.jersey.spring.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.validation.constraints.NotNull;

@Path("/greeting")
public interface GreetingResource {
    @GET
    Response getGreeting(@NotNull @QueryParam("name") String name);
}
