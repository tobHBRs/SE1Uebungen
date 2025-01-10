package org.hbrs.se1.ws24.exercises.uebung9;

public abstract class AbstractDocument implements Document{
    private int id;
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
}
