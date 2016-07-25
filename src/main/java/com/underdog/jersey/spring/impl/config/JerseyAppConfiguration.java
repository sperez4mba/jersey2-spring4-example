
package com.underdog.jersey.spring.impl.config;

import java.time.Instant;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author PaulSamsotha
 */
@ApplicationPath("/rest")
public class JerseyAppConfiguration extends ResourceConfig {

    public JerseyAppConfiguration() {
//    public JerseyAppConfiguration(@Context MockServletContext context) {
        packages("com.underdog.jersey.spring");
        System.out.println("yay at " + Instant.now());
    }

}
