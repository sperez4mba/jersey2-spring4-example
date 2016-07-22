
package com.underdog.jersey.spring.impl.config;

import java.time.Instant;
import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author PaulSamsotha
 */
@ApplicationPath("/rest")
public class JerseyAppConfiguration extends ResourceConfig {

    public JerseyAppConfiguration() {
    }

    @Context
    public void post_construct(ServletContext servletContext) {
        packages("com.underdog.jersey.spring.example");
        System.out.println("yay at " + Instant.now());
    }

}
