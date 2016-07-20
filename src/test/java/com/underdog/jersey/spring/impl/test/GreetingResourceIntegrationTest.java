
package com.underdog.jersey.spring.impl.test;

import static org.junit.Assert.assertEquals;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.spring.SpringLifecycleListener;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.underdog.jersey.spring.impl.config.JerseyAppConfiguration;
import com.underdog.jersey.spring.impl.config.SpringAppConfiguration;

/**
 * @author PaulSamsotha
 */
public class GreetingResourceIntegrationTest extends JerseyTest {


    // For some reason JerseyTest does not invoke the @Context method in the ResourceConfig

    @Override
    public Application configure() {
        JerseyAppConfiguration config = new JerseyAppConfiguration();
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(SpringAppConfiguration.class);
        context.getEnvironment().setActiveProfiles("production");
        config.register(SpringLifecycleListener.class).register(RequestContextFilter.class);

//        MockServletContext mockServletContext = new MockServletContext();
//        GenericWebApplicationContext genericWebApplicationContext = new GenericWebApplicationContext(mockServletContext);
//        mockServletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, genericWebApplicationContext);
//        genericWebApplicationContext.setParent(context);
//        genericWebApplicationContext.refresh();
        config.property("contextConfig", context);
//        config.post_construct(mockServletContext);
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
