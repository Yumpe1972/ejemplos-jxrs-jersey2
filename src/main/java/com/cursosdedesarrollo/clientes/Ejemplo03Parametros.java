package com.cursosdedesarrollo.clientes;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class Ejemplo03Parametros {

    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());

        String response = target.path("rest")
                .path("/testservice")
                .path("parametros")
                .queryParam("start","0")
                .queryParam("size","11")
                .request()
                .accept(MediaType.TEXT_PLAIN)
                .get(Response.class)
                .toString();

        System.out.println(response);

    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8084/jersey2-demo").build();
    }
}