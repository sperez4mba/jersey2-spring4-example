/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.underdog.jersey.spring.api.service;

import java.util.Map;

/**
 *
 * @author PaulSamsotha
 */
public interface HeaderService {
    Map<String, String> getHeaders();
}