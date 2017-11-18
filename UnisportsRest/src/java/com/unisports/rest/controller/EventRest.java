package com.unisports.rest.controller;

import com.unisports.bl.EventBL;
import com.unisports.entities.Event;
import java.io.IOException;
import java.util.UUID;
import javafx.util.Pair;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

@Path("/Event")
@RequestScoped
public class EventRest {
    
    @Context
    private UriInfo context;

    @POST
    @Path("/Create")
    public String regiter(String content) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();

        try {
            Event event = mapper.readValue(content, Event.class);
            
            if (event != null) {
                event.setId(UUID.randomUUID());
                EventBL eventService = new EventBL();
                Pair<Boolean, String> result = eventService.SaveEvent(event);

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
            response.put("exception", ex.getMessage());

            return response.toString();
        }
    }
    
}
