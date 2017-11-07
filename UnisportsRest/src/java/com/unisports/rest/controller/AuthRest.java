/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.rest.controller;

import com.unisports.bl.AuthBL;
import javafx.util.Pair;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

@Path("/Auth")
@RequestScoped
public class AuthRest {

    @POST
    @Path("/Login")
    public String login(@QueryParam("email") String email, @QueryParam("password") String password) {
        AuthBL authService = new AuthBL();
        
        Pair<Boolean, String> result = authService.validateCredentials(email, password);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();
        response.put("result", result.getKey());
        response.put("message", result.getValue());

        System.out.println(response.toString());
        
        return response.toString();
    }
}
