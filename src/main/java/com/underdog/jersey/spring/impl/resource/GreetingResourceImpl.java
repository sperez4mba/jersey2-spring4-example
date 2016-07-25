
package com.underdog.jersey.spring.impl.resource;

import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.underdog.jersey.spring.api.resource.GreetingResource;
import com.underdog.jersey.spring.api.service.GreetingService;

@Service
public class GreetingResourceImpl implements GreetingResource {

    @Autowired
    private GreetingService greetingService;

    @Override
    public Response getGreeting(String name) {
        String greeting = greetingService.getGreeting(name);
        return Response.ok(greeting).build();
    }

}
