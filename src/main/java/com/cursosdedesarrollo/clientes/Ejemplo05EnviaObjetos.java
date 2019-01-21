package com.cursosdedesarrollo.clientes;

import com.cursosdedesarrollo.app.Ejemplo04Objeto;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;


public class Ejemplo05EnviaObjetos {

    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());
        WebTarget objetosWebTarget
                = target.path("rest/cogeobjetos");
        Ejemplo04Objeto objeto=new Ejemplo04Objeto("pepe","san");
        Invocation.Builder invocationBuilder
                = objetosWebTarget.request(MediaType.APPLICATION_JSON);
        Response respuesta=invocationBuilder.post(Entity.entity(objeto,MediaType.APPLICATION_JSON));
        int status=respuesta.getStatus();
        System.out.println("Status:"+status);
        String cuerpo=respuesta.getEntity().toString();
        System.out.println("Cuerpo:"+respuesta.readEntity(String.class));






    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:9090").build();
    }

}