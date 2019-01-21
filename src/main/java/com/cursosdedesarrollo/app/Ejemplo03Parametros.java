package com.cursosdedesarrollo.app;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("/testservice")
public class Ejemplo03Parametros {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTestService() {
        return "Hello World! This is coming from webservice!!";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getId(@PathParam("id") String id){
        return  id;
    }

    @GET
    @Path("/{model}/{year}")
    @Produces("image/jpeg")
    public String getPicture(@PathParam("model") String model,
                           @PathParam("year") String year) {
        return model+year;
    }

    // GET /testservice/parametros?start=0&size=10
    @GET
    @Path("/parametros")
    public String getCustomers(@QueryParam("start") int start,
                               @QueryParam("size") int size) {
        return new Integer(start).toString()+" "+new Integer(size).toString();
    }

    /*
    <FORM action="http://example.com/customers" method="post">
        <P>
        First name: <INPUT type="text" name="firstname"><BR>
        Last name: <INPUT type="text" name="lastname"><BR>
        <INPUT type="submit" value="Send">
        </P>
    </FORM>
     */
    @POST
    @Path("/postForm")
    public String createCustomer(@FormParam("firstname") String first,
                               @FormParam("lastname") String last) {
        return first+" "+last;
    }

    // Cookies
    @GET
    @Path("/cookies")
    @Produces("text/html")
    public String get(@CookieParam("customerId") int custId) {
        return new Integer(custId).toString();
    }
}