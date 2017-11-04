/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.rest.controller;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author koraniar
 */
@Path("/tess")
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
     * Retrieves representation of an instance of com.unisports.rest.controller.TestsResource
     * @return an instance of java.lang.String
     */
    @GET
    public String getJson() {
        return "lo que sea";
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of TestResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public TestResource getTestResource(@PathParam("id") String id) {
        return TestResource.getInstance(id);
    }
}
