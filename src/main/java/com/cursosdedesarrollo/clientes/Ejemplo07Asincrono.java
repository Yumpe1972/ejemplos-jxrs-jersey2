package com.cursosdedesarrollo.clientes;

import org.glassfish.jersey.client.ClientConfig;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Ejemplo07Asincrono {

    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        Future<Response> future1 =
            client.target("http://localhost:9090/rest/asincrono")
                .request()
                .async()
                .get();

        Response res = null;
        String result1 = null;
        try {
            // block until complete
            res = future1.get();
            result1 = res.readEntity(String.class);
            System.out.println("Resultado: "+result1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // Wait 5 seconds
        try {
            Response result2 = future1.get(5, TimeUnit.SECONDS);
            System.out.println("Resultado: "+result2.getStatus());
            //System.out.println("Resultado: "+result2.readEntity(String.class));
        } catch (TimeoutException timeout ) {
            System.err.println("request timed out");
        } catch (InterruptedException ie) {
            System.err.println("Request was interrupted");
        } catch (ExecutionException ee) {
            Throwable cause = ee.getCause();
        }

        Future<Response> future2 = client.target("http://localhost:9090/rest/asincrono")
                .request()
                .async().get(new CustomerCallback());

        Future<Response> future3 = client.target("http://localhost:9090/rest/asincrono/server")
                .request()
                .async().get(new CustomerCallback());

    }

    public static class CustomerCallback implements InvocationCallback<Response> {
        private static int req=0;
        public void completed(Response response) {
            String resp= null;
            if (response.getStatus() == 200) {
                resp = response.readEntity(String.class);
                System.out.println("Resultado: "+resp);
                if(req==1){
                    System.exit(1);
                }
                req++;
            } else {
                System.err.println("Request error: " + response.getStatus());
            }
        }

        public void failed(Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}