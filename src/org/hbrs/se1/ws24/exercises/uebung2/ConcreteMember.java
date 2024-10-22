package org.hbrs.se1.ws24.exercises.uebung2;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable {
    //Um die Liste von Member Objecten zu speichern müssen diese Serializable sein (Ermöglicht die Umwandlung eines Objectes in einen Stream)
    private int ID;
    public ConcreteMember(int ID){
        this.ID = ID;
    }
    @Override
    public Integer getID() {
        return this.ID;
    }

    @Override
    public String toString() {
        return "Member (ID = " + this.getID() + " )";
    }
}
