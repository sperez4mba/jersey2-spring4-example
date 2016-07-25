
package com.underdog.jersey.spring.impl.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.underdog.jersey.spring.api.service.HeaderService;
import com.underdog.jersey.spring.impl.service.UnderdogHeaderService;

@Component
@Configuration
@ComponentScan(basePackages = {
        "com.underdog.jersey.spring.impl.filter",
        "com.underdog.jersey.spring.impl.json",
        "com.underdog.jersey.spring.impl.service",
        "com.underdog.jersey.spring.impl.resource"
})
public class SpringAppConfiguration {
    
    @Configuration
    //@Profile("production")
    static class HeaderServiceConfiguration {
        
        @Bean
        public HeaderService headerService() {
            return new UnderdogHeaderService();
        }
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }

    @Bean
    public BeanPostProcessor validationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
