
package com.underdog.jersey.spring.impl.resource;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.underdog.jersey.spring.api.resource.GreetingResource;
import com.underdog.jersey.spring.api.service.GreetingService;

@Service
@Validated
public class GreetingResourceImpl implements GreetingResource {

    @Autowired
    private GreetingService greetingService;

    @Override
    public Response getGreeting(@NotNull @QueryParam("name") String name) {
        String greeting = greetingService.getGreeting(name);
        return Response.ok(greeting).build();
    }

}
