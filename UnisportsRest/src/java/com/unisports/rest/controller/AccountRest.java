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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

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
            response.put("message", "Error, los datos no son válidos");
            return response.toString();
        } catch (IOException ex) {
            response.put("result", false);
            response.put("message", "Error inesperado, por favor intente de nuevo más tarde");
            response.put("exception", ex.getMessage());
            return response.toString();
        }
    }
    
    @POST
    @Path("/EditUser")
    public String editUser(String content) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();

        try {
            User user = mapper.readValue(content, User.class);

            if (user != null) {
                UserBL userService = new UserBL();
                boolean result = userService.updateUser(user);

                response.put("result", result);
                response.put("message", result ? "" : "No se pudo actualizar la información por favor intente de nuevo más tarde");
                return response.toString();
            }
            response.put("result", false);
            response.put("message", "Error, los datos no son válidos");
            return response.toString();
        } catch (IOException ex) {
            response.put("result", false);
            response.put("message", "Error inesperado, por favor intente de nuevo más tarde");
            response.put("exception", ex.getMessage());
            return response.toString();
        }
    }

    @GET
    @Path("/GetUser")
    public String getUser(@QueryParam("id") UUID id) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();

        try {
            UserBL userService = new UserBL();
            User user = userService.getUserById(id);

            if (user != null) {
                response.put("result", true);
                response.put("user", mapper.writeValueAsString(user));
                return response.toString();
            }
            response.put("result", false);
            response.put("message", "El usuario no existe");
            return response.toString();
        } catch (IOException ex) {
            response.put("result", false);
            response.put("message", "Error inesperado, por favor intente de nuevo mas tarde");
            response.put("exception", ex.getMessage());
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
