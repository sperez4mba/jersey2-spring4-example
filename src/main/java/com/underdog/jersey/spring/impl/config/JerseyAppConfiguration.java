
package com.underdog.jersey.spring.impl.config;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.underdog.jersey.spring.api.resource.GreetingResource;
import com.underdog.jersey.spring.impl.filter.RandomHeaderFilter;
import com.underdog.jersey.spring.impl.json.ModelResourceImpl;
import com.underdog.jersey.spring.impl.json.ObjectMapperContextResolver;

@ApplicationPath("/rest")
public class JerseyAppConfiguration extends ResourceConfig {

    public JerseyAppConfiguration(@Context ServletContext context) {
        WebApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(context);

        register(appCtx.getBean(ObjectMapperContextResolver.class));
        register(appCtx.getBean(RandomHeaderFilter.class));

        register(appCtx.getBean(GreetingResource.class));
        register(appCtx.getBean(ModelResourceImpl.class));
    }

}
