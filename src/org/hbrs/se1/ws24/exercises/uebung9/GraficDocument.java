package org.hbrs.se1.ws24.exercises.uebung9;

public class GraficDocument extends AbstractCoreDocument{
    private int size = 1200;
    private String url;
    public int size(){
        return size;
    }
    public GraficDocument(String url){
        this.url = url;
    }
}
