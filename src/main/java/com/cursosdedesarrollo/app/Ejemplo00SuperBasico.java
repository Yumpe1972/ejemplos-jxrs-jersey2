package com.cursosdedesarrollo.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/sayhello")
public class Ejemplo00SuperBasico {

    @GET
    public Response restHome(){
        return Response.status(200).entity("Home").build();
    }

}
