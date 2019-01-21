package com.cursosdedesarrollo.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/objetos")
public class Ejemplo04SalidaObjetos {

    // This method is called if XML is requested
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Ejemplo04Objeto getXML() {
        Ejemplo04Objeto objeto = new Ejemplo04Objeto();
        objeto.setSummary("Application XML Todo Summary");
        objeto.setDescription("Application XML Todo Description");
        return objeto;
    }

    // This method is called if JSON is requested
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Ejemplo04Objeto getJSON() {
        Ejemplo04Objeto todo = new Ejemplo04Objeto();
        todo.setSummary("Application JSON Todo Summary");
        todo.setDescription("Application JSON Todo Description");
        return todo;
    }

    // This can be used to test the integration with the browser
    @GET
    @Produces({ MediaType.TEXT_XML })
    public Ejemplo04Objeto getHTML() {
        Ejemplo04Objeto objeto = new Ejemplo04Objeto();
        objeto.setSummary("XML Todo Summary");
        objeto.setDescription("XML Todo Description");
        return objeto;
    }

}