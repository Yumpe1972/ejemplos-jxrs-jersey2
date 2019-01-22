package com.cursosdedesarrollo.app;

import javax.ws.rs.*;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/errores")
public class Ejemplo06ErroresSalidas {

    @GET
    @Path("/error1")
    @Produces("text/plain")
    public Response getItem() {
        String book = "Libro";
        Response.ResponseBuilder builder = Response.ok(book);
        builder.language("es")
                .status(200)
                .header("Parametro-Cabecera", "valor");
        return builder.build();
    }
    @GET
    @Path("/cookie")
    public Response get() {
        NewCookie cookie = new NewCookie("clave", "valor");
        Response.ResponseBuilder builder = Response.ok("Datos de la entidad", "text/plain");
        return builder.cookie(cookie).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getCustomer(@PathParam("id") Integer id) {

        if (id == null) {
            throw new NotFoundException();
        }
        return Response.ok(id).build();
    }
}
