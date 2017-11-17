/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.rest.controller;

import com.unisports.bl.UserBL;
import com.unisports.entities.User;
import java.io.IOException;
import java.util.UUID;
import javafx.util.Pair;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

/**
 *
 * @author koraniar
 */
@Path("/Account")
@RequestScoped
public class AccountRest {

    @Context
    private UriInfo context;

    @POST
    @Path("/Register")
    public String regiter(String content) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();

        try {
            User user = mapper.readValue(content, User.class);
            
            if (user != null) {
                user.setId(UUID.randomUUID());
                UserBL userService = new UserBL();
                Pair<Boolean, String> result = userService.registerUser(user);

                response.put("result", result.getKey());
                response.put("message", result.getValue());
                return response.toString();
            }
            response.put("result", false);
            response.put("message", "Error, los datos no son validos");
            return response.toString();
        } catch (IOException ex) {
            response.put("result", false);
            response.put("message", "Error inesperado, por favor intente de nuevo mas tarde");
            return response.toString();
        }
    }
    
    @GET
    @Path("/ping")
    //@Consumes(MediaType.APPLICATION_JSON)
    public String ping(String content) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();
        
                response.put("result", true);
                response.put("message", "Ok");
                return response.toString();
    }

}
