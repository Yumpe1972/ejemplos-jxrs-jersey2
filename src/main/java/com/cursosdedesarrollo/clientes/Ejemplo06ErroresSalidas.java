package com.cursosdedesarrollo.clientes;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class Ejemplo06ErroresSalidas {

    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());



        String plainAnswer =
                target.path("rest/errores/error1").request().accept(MediaType.TEXT_PLAIN).get(String.class);

        System.out.println(plainAnswer);
        Response respuesta=target.path("rest/errores/cookie").request().accept(MediaType.TEXT_PLAIN).get();
        System.out.println("Cookie Status"+respuesta.getStatus());
        System.out.println("Cookies: "+respuesta.getCookies());

        respuesta=target.path("rest/errores/1").request().accept(MediaType.TEXT_PLAIN).get();
        System.out.println("Status ID: " + respuesta.getStatus());
        System.out.println("ID Entity: " + respuesta.readEntity(String.class));

        respuesta=target.path("rest/errores/").request().accept(MediaType.TEXT_PLAIN).get();
        System.out.println("Status ID: " + respuesta.getStatus());
        System.out.println("ID Entity: " + respuesta.readEntity(String.class));
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:9090").build();
    }
}