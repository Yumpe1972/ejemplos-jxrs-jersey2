package com.cursosdedesarrollo.app;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/prueba")
public class EjemploPrueba {
        @GET
        public Response restPostHome(){

            return Response.status(200).entity("I can´t belive it").build();
        }
     }
