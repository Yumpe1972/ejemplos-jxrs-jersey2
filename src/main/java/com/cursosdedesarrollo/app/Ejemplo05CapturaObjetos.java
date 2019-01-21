package com.cursosdedesarrollo.app;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/cogeobjetos")
public class Ejemplo05CapturaObjetos {

    // This method is called if XML is requested
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Ejemplo04Objeto getXML() {
        Ejemplo04Objeto objeto= new Ejemplo04Objeto("pepe","san");
        objeto.setSummary("Application XML Todo Summary");
        objeto.setDescription("Application XML Todo Description");
        return objeto;
    }

    // This method is called if JSON is requested
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Ejemplo04Objeto getJSON() {
        Ejemplo04Objeto objeto= new Ejemplo04Objeto("pepe","san");
        Ejemplo04Objeto todo = new Ejemplo04Objeto();
        todo.setSummary("Application JSON Todo Summary");
        todo.setDescription("Application JSON Todo Description");
        return todo;
    }

    // This can be used to test the integration with the browser
    @GET
    @Produces({ MediaType.TEXT_XML })
    public Ejemplo04Objeto getHTML() {
        Ejemplo04Objeto objeto= new Ejemplo04Objeto("pepe","san");
        objeto.setSummary("XML Todo Summary");
        objeto.setDescription("XML Todo Description");
        return objeto;
    }
    // This method is called if XML is requested
    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Ejemplo04Objeto postXML(Ejemplo04Objeto objeto) {
        //objeto.setSummary("Application XML Todo Summary");
        //objeto.setDescription("Application XML Todo Description");
        return objeto;
    }

    // This method is called if JSON is requested
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Ejemplo04Objeto postJSON(Ejemplo04Objeto objeto) {
        //Ejemplo04Objeto todo = new Ejemplo04Objeto();
        //todo.setSummary("Application JSON Todo Summary");
        //todo.setDescription("Application JSON Todo Description");
        return objeto;
    }

    // This can be used to test the integration with the browser
    @POST
    @Consumes({ MediaType.TEXT_XML })
    @Produces({ MediaType.TEXT_XML })
    public Ejemplo04Objeto postHTML(Ejemplo04Objeto objeto) {
        //objeto.setSummary("XML Todo Summary");
        //objeto.setDescription("XML Todo Description");
        return objeto;
    }

}