package com.cursosdedesarrollo.app;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ejemplo04Objeto{
    private String summary;
    private String description;

    public Ejemplo04Objeto(){
        this.summary="";
        this.description="";

    }
    public Ejemplo04Objeto(String summary, String description){
        this.summary=summary;
        this.description=description;

    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
