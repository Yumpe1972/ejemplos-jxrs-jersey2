package com.cursosdedesarrollo.app;

//import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class Ejemplo08CustomApplication extends ResourceConfig{
    public Ejemplo08CustomApplication()
    {
        packages("com.cursosdedesarrollo.app");
        //register(LoggingFilter.class);
        //register(Ejemplo08GsonMessageBodyHandler.class);

        //Register Auth Filter here
        //register(Ejemplo08AuthFilter.class);
    }
}
