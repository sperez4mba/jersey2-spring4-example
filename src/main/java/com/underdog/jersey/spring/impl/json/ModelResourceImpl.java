/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.underdog.jersey.spring.impl.json;

import javax.ws.rs.core.Response;
import org.springframework.stereotype.Service;
import com.underdog.jersey.spring.api.resource.ModelResource;

@Service
public class ModelResourceImpl implements ModelResource {
    
    @Override
    public Response getResponse() {
        Model model = new Model("Peeskillet");
        return Response.ok(model).build();
    }
}
