package com.unisports.rest.controller;

import com.unisports.bl.TeamBL;
import com.unisports.entities.Team;
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

@Path("/Team")
@RequestScoped
public class TeamRest {
    
    @Context
    private UriInfo context;

    @POST
    @Path("/Create")
    public String regiter(String content) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();

        try {
            Team team = mapper.readValue(content, Team.class);

            if (team != null) {
                team.setId(UUID.randomUUID());
                TeamBL teamService = new TeamBL();
                Pair<Boolean, String> result = teamService.SaveTeam(team);

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
}
