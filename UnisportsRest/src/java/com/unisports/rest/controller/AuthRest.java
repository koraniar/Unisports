package com.unisports.rest.controller;

import com.unisports.bl.AuthBL;
import com.unisports.entities.User;
import java.math.BigDecimal;
import javafx.util.Pair;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

@Path("/Auth")
@RequestScoped
public class AuthRest {

    @GET
    @Path("/Login")
    public String login(@QueryParam("email") String email, @QueryParam("password") String password) {
        AuthBL authService = new AuthBL();

        Pair<User, String> result = authService.validateCredentials(email, password);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();
        
        if(result.getKey() != null){
            response.put("result", true);
            if (result.getKey().getName().isEmpty()) {
                response.put("complete", false);
                response.put("initials", "UN");
            }else{
                response.put("complete", true);
                response.put("initials", result.getKey().getLastName().isEmpty() ? result.getKey().getName().substring(0, 2) : 
                        result.getKey().getName().substring(0, 1) + result.getKey().getLastName().substring(0, 1));
            }
            
            
        } else {
            response.put("result", false);
        }
        
        response.put("message", result.getValue());

        return response.toString();
    }
}
