package org.hbrs.se1.ws24.exercises.uebung11.CRMAdapter;

public class CRMAdapterImpl {
    private Client transformEingabe(Contact c){
        Client cl = new Client();
        cl.name = c.vorname + " " +  c.nachname;
        return cl;
    }
}
