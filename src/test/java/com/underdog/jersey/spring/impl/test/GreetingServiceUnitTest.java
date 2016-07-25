
package com.underdog.jersey.spring.impl.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.underdog.jersey.spring.api.service.GreetingService;
import com.underdog.jersey.spring.impl.config.SpringAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringAppConfiguration.class})
public class GreetingServiceUnitTest {
    
    @Autowired
    private GreetingService greetingService;
    
    @Test
    public void testFrenchGreeting() {
        String greeting = greetingService.getGreeting("peeskillet");
        Assert.assertEquals("Bonjour, peeskillet!", greeting);
    }
}
