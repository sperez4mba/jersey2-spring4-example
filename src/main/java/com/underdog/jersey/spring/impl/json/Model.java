/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.underdog.jersey.spring.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("model")
public class Model {
    @JsonProperty("name")
    public final String name;

    @JsonCreator
    public Model(@JsonProperty("name") String name) {
        this.name = name;
    }
}
