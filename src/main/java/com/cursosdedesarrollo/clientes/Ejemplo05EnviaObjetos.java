package com.cursosdedesarrollo.clientes;

import com.cursosdedesarrollo.app.Ejemplo04Objeto;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;


public class Ejemplo05EnviaObjetos {

    public static void main(String[] args) {
        //Configuración del cliente
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        // Establecimiento de la URL base
        WebTarget target = client.target(getBaseURI());
        // Selección de la URL del recurso
        WebTarget objetosWebTarget
                = target.path("rest/cogeobjetos");
        // Inicialización del objeto a enviar
        Ejemplo04Objeto objeto=new Ejemplo04Objeto("pepe","san");
        // Selección del tipo de Dato enviado
        Invocation.Builder invocationBuilder
                = objetosWebTarget.request(MediaType.APPLICATION_JSON);
        // Llamada Post con Datos
        Response respuesta=invocationBuilder
                .post(Entity.entity(objeto,MediaType.APPLICATION_JSON));
        // Extracción de datos
        int status=respuesta.getStatus();
        System.out.println("Status:"+status);
        String cuerpo=respuesta.getEntity().toString();
        System.out.println("Cuerpo:"+respuesta.readEntity(String.class));

        //Reconfiguración del cliente
        client = ClientBuilder.newClient().register(new JacksonFeature());
        target = client.target(getBaseURI());
        objetosWebTarget = target.path("rest/cogeobjetos");
        invocationBuilder
                = objetosWebTarget.request(MediaType.APPLICATION_JSON);
        // Llamada Post con datos, recogiendo un Dato ya desserializado
        Ejemplo04Objeto objeto2 = invocationBuilder
                .post(Entity.entity(objeto, MediaType.APPLICATION_JSON), Ejemplo04Objeto.class);

        // Extracción de Datos
        System.out.println(objeto2.getSummary());
        System.out.println(objeto2.getDescription());

        // Selección del recurso
        objetosWebTarget = target.path("rest/objetos");
        invocationBuilder
                = objetosWebTarget.request(MediaType.APPLICATION_JSON);
        // Llamada Get recogiendo el objeto ya desserializado
        objeto2=invocationBuilder
                .get(new GenericType<Ejemplo04Objeto>() {});
        // Extracción de datos
        System.out.println(objeto2.getSummary());
        System.out.println(objeto2.getDescription());






    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:9090").build();
    }

}