
package com.underdog.jersey.spring.impl.test;

import static org.junit.Assert.assertEquals;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import com.underdog.jersey.spring.impl.config.JerseyAppConfiguration;
import com.underdog.jersey.spring.impl.config.SpringAppConfiguration;

/**
 * @author PaulSamsotha
 */
public class GreetingResourceIntegrationTest extends JerseyTest {


    // For some reason JerseyTest does not invoke the @Context method in the ResourceConfig



    @Override
    public Application configure() {
// OLD
//        JerseyAppConfiguration config = new JerseyAppConfiguration();
//        AnnotationConfigApplicationContext context
//                = new AnnotationConfigApplicationContext(SpringAppConfiguration.class);
//        context.getEnvironment().setActiveProfiles("production");
//        config.property("contextConfig", context);

        // NEW
        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();
        context.register(SpringAppConfiguration.class);
        context.getEnvironment().setActiveProfiles("production");
        context.refresh();
//        MockServletContext mockServletContext = new MockServletContext();
//        mockServletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);
//
        JerseyAppConfiguration config = new JerseyAppConfiguration();
//        config.register(SpringLifecycleListener.class).register(RequestContextFilter.class);
//
//
        config.property("contextConfig", context); // from SpringComponentProvider.PARAM_SPRING_CONTEXT="contextConfig"
        return config;
    }

    @Test
    public void testGetGreeting() {
        Response response = target("greeting").queryParam("name", "peeskillet")
                                              .request().get();

        assertEquals("Underdog", response.getHeaderString("X-Powered-By"));
        String message = response.readEntity(String.class);
        assertEquals("Bonjour, peeskillet!", message);
        System.out.println(message);

        response.close();
    }
}
