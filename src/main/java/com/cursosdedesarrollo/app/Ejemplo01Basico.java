package com.cursosdedesarrollo.app;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/sayhello")
public class Ejemplo01Basico {

    @POST
    public Response restPostHome(){
        return Response.status(200).entity("Post Home").build();
    }
    @GET
    // entraría con /rest/sayhello/{name}
    @Path("/{name}")
    public Response sayHello(@PathParam("name") String msg) {
        String output = "Hello, " + msg + "!";
        return Response.status(200).entity(output).build();
    }

}
