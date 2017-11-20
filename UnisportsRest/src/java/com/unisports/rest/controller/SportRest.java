package com.unisports.rest.controller;

import com.unisports.dao.SportDAO;
import com.unisports.entities.Sport;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;


@Path("/Sport")
@RequestScoped
public class SportRest {
    
    @Context
    private UriInfo context;

    @GET
    @Path("/GetAll")
    public String getAllSports() {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            SportDAO sportService = new SportDAO();
            List<Sport> sports = sportService.getAllSports();
            
            String response = mapper.writeValueAsString(sports);
            
            return response;
        } catch (IOException ex) {
            ObjectNode response = mapper.createObjectNode();
            response.put("result", false);
            response.put("message", "Error inesperado, por favor intente de nuevo mas tarde");
            return response.toString();
        }
    }
}
