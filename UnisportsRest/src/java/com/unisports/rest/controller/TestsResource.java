/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.rest.controller;

import com.unisports.entities.Sport;
import com.unisports.enums.SportType;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * REST Web Service
 *
 * @author koraniar
 */
@Path("/test")
@RequestScoped
public class TestsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TestsResource
     */
    public TestsResource() {
    }

    /**
     * POST method for creating an instance of TestResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    //@Consumes(MediaType.APPLICATION_JSON)
    public String postJson(@DefaultValue("default") @QueryParam("user") String user, String sport) {
        try {
            System.out.println(user);
            //TODO
            ObjectMapper mapper = new ObjectMapper();
            
            Sport object = mapper.readValue(sport, Sport.class);
            
            if (object != null) {
                System.out.println(object.getId().toString());                
                System.out.println(object.getName());
                System.out.println(object.getType().toString());

            }else{
                System.out.println("error");
            }
            
            return "ok ok";
            //return Response.ok("{'Message' : 'ok' }").build();
        } catch (IOException ex) {
            return "ex";
            //return Response.ok("{'Message' : 'error' }").build();
        }
    }

    /**
     * Sub-resource locator method for {id}
     */
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTestResource(@PathParam("name") String name) {
        //Accepts:
        //http://localhost:8080/UnisportsRest/rest/test/hola
        
        Sport sp = new Sport();
        sp.setName(name);
        sp.setType(SportType.Futbol);
        
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            return mapper.writeValueAsString(sp);
            
            //TODO return proper representation object
            //throw new UnsupportedOperationException();
        } catch (IOException ex) {
            return "error";
            //Logger.getLogger(TestsResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Retrieves representation of an instance of com.unisports.rest.controller.TestsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@DefaultValue("default") @QueryParam("name") String name) {
        //Accepts:
        //http://localhost:8080/UnisportsRest/rest/test?name=hola
        
        Sport sp = new Sport();
        sp.setName(name);
        sp.setType(SportType.Futbol);
        
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            return mapper.writeValueAsString(sp);
            
            //TODO return proper representation object
            //throw new UnsupportedOperationException();
        } catch (IOException ex) {
            return "error";
            //Logger.getLogger(TestsResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
