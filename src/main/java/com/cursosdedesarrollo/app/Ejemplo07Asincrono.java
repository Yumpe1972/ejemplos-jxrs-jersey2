package com.cursosdedesarrollo.app;

import javax.ejb.Asynchronous;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("/asincrono")
public class Ejemplo07Asincrono {

    @GET
    public Response sayASync() {
        String output = "Hello, Async!";
        try {
            Thread.sleep(5000);
            return Response.status(200).entity(output).build();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/server")
    @Asynchronous
    public void asyncRestMethod(@Suspended final AsyncResponse asyncResponse) {
        String result = heavyLifting();
        asyncResponse.resume(result);
    }
    private String heavyLifting() {
        try {
            Thread.sleep(5000);
            return "RESULT";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "NO Result";
    }


}
