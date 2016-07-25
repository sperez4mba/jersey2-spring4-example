# Jersey and Spring Example with Java Config (no `web.xml`)

This is a fork of https://github.com/peeskillet/underdog-jersey-spring-example, it helped 
a lot to go a bit further in integrating Spring and Jersey. Unfortunately the project is 
based on Spring 3, and doesn't allow a precise control of JAX-RS filter, resources 
registration. This fork intends to remedies to that. 

The original tet still apply : 

> There are Jersey - Spring integrated examples out there using `web.xml` configuration,
> but I haven't found many that used all Java configurations. It may be due to the fact
> that there is no examples in the Jersey documentation, or that fact that the way
> the `jersey-spring3` module is built makes it difficult to make this integration,
> without digging into the source code.
>
> What happens is that Jersey's `SringWebInitializer` registers its own 
> `ContextLoaderListener` and our attempt to load another one from our 
> `WebApplicationInitializer` causes an exception to be thrown. This caused a lot 
> of headache for me. 
>
> I then discovered this [issue filed](https://java.net/jira/browse/JERSEY-2038) which
> had some work-arounds. So I put together a little project, taking some helpful hints
> from comments.

Improvements are :

* Java 1.8
* Spring 4.3.x (jersey imports 3.x)
* Split interface / implementation
* Controlled `ResourceConfig` initialization (which resources, which filter in specific order)
* Logging
* Declared constant where possible
* Jackson 2.7.3 (jersey imports 2.5.4)
* Method validation (note that HK2 imports an older repackaged version)

**Required:** Maven (to build)

**Recommended:** [cURL](http://curl.haxx.se/) (for testing)

### Build, Run, and Test:

1. Package Maven project (after resolving dependencies, two test should be ran and should pass)

        mvn clean package

2. Run project with [jetty-maven-plugin](http://eclipse.org/jetty/documentation/current/jetty-maven-plugin.html). 
This is not required, but I prefer it in development, rather than deploying to local server instance.

        mvn jetty:run

3. Run cURL command to test (not required, you can simple use the browser url bar

        curl -i http://localhost:8080/rest/greeting?name=Peeskillet
        
    **Result**

        HTTP/1.1 200 OK
        Content-Type: text/plain
        Content-Length: 20
        Server: Jetty(9.2.4.v20141103)

        Bonjour, Peeskillet!


4. Added Jackson and configured ObjectMapper as a `@Bean` and injected it into the 
    the `ObjectMapperContextResolver`. The configuration is simple. It's just formatting
    the JSON, just to show the configuration works

    You can run the app with `mvn jetty:run` and go to 

        curl -v http://localhost:8080/rest/model
    
    **Result**

        HTTP/1.1 200 OK
        Server: Apache-Coyote/1.1
        X-Powered-By: Underdog
        Content-Type: application/json
        Content-Length: 27
        Date: Mon, 25 Jul 2016 21:54:52 GMT
        
        {
          "name" : "Peeskillet"
        }
        
5. Run cURL command to test without param

    curl -i http://localhost:8080/rest/greeting?name=Peeskillet
    
    **Result**
    
        HTTP/1.1 400 Bad Request
        Server: Apache-Coyote/1.1
        X-Powered-By: Underdog
        Content-Type: text/plain
        Content-Length: 394
        Date: Mon, 25 Jul 2016 22:38:25 GMT
        Connection: close
        
        HV000151: A method overriding another method must not alter the parameter constraint configuration, but method public javax.ws.rs.core.Response com.underdog.jersey.spring.impl.resource.GreetingResourceImpl.getGreeting(java.lang.String) changes the configuration of public abstract javax.ws.rs.core.Response com.underdog.jersey.spring.api.resource.GreetingResource.getGreeting(java.lang.String).     