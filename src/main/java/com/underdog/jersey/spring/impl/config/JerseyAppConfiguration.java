
package com.underdog.jersey.spring.impl.config;

import java.time.Instant;
import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author PaulSamsotha
 */
@ApplicationPath("/rest")
public class JerseyAppConfiguration extends ResourceConfig {

    public JerseyAppConfiguration() {
    }

    @Context
    public void post_construct(ServletContext servletContext) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        packages("com.underdog.jersey.spring.example");
        System.out.println("yay at " + Instant.now());
    }

}
