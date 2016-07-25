
package com.underdog.jersey.spring.impl.service;

import org.springframework.stereotype.Service;
import com.underdog.jersey.spring.api.service.GreetingService;

@Service
public class FrenchGreetingService implements GreetingService {

    @Override
    public String getGreeting(String name) {
        return "Bonjour, " + name + "!";
    }  
}
