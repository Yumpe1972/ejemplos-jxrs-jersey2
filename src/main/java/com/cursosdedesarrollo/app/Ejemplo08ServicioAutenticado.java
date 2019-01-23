package com.cursosdedesarrollo.app;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/admin")
public class Ejemplo08ServicioAutenticado {
    @RolesAllowed("ADMIN")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/objetoSeguro")
    public List<Ejemplo04Objeto> getAllEmployees()
    {
        List<Ejemplo04Objeto> listado = new ArrayList<>();
        listado.add(new Ejemplo04Objeto("pepe","san"));
        listado.add(new Ejemplo04Objeto("juan","perez"));

        return listado;
    }
    @PermitAll
    @Path("/objetoNoSeguro")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ejemplo04Objeto> getAllEmployeesNotSecure()
    {
        List<Ejemplo04Objeto> listado = new ArrayList<>();
        //listado.add(new Ejemplo04Objeto("pepe","san"));
        listado.add(new Ejemplo04Objeto("juan","perez"));

        return listado;
    }

}
