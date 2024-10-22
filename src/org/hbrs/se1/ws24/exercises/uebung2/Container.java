package org.hbrs.se1.ws24.exercises.uebung2;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.*;

import java.util.ArrayList;
import java.util.List;
//Java singleton pattern: Stellt sicher das nur ein Object pro Klasse erzeugt werden kann, indem:
// --> der Konstruktor private gemacht wird = keine erzeugung von außen möglich
// --> das erzeugte Object als static Variable definiert ist
// --> statische getContainer Methode um auf die einzige Instanziierung des Objects zu zugreifen
public class Container {
    private static Container container;
    private PersistenceStrategy<Member> persistenceStrategy; //Strategie für load/store
    ArrayList<Member> memberlist;
    private Container(){ //Privater Konstruktor verhindert erzeugung außerhalb der Klasse
        memberlist = new ArrayList<Member>();
    }
    public static Container getContainer(){
        if(container == null){
            container = new Container();
        }
        return container;
    }
    public void setPersistenceStrategy(PersistenceStrategy<Member> p){
        this.persistenceStrategy = p;
    }

    public void store() throws PersistenceException {
        if(persistenceStrategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NullPointer, "Keine Strategy ausgewählt");
        }
        persistenceStrategy.save(memberlist);
    }

    public void load()throws PersistenceException{
        if(persistenceStrategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NullPointer, "Keine Strategy ausgewählt");
        }
        memberlist = (ArrayList<Member>) persistenceStrategy.load();

    }

    //FA1 hinzufügen des Member Objects und überprüft ob es bereits vorhanden ist
    public void addMember(Member n) throws ContainerException {
        for(Member m : memberlist){
            if(m.getID().equals(n.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID " + m.getID() + " ist bereits vorhanden!");
            }
        }
        memberlist.add(n);
    }
    //FA2 löschen eines Member Objects falls vorhanden
    public String deleteMember(int id){
        for(Member m : memberlist){
            if(m.getID().equals(id)){
                memberlist.remove(m);
                return "Member mit der ID " + m.getID() + " wurde erfolgreich entfernt.";
            }
        }
        return "Fehler: Member mit der ID " + id + " konnte nicht gefunden werden.";
    }
    //FA3: Ausgabe der IDs aller Objekte
    /*/public void dump(){
        for(Member m : memberlist){
            System.out.println(m.toString());
        }
    }*/
    //FA4 Anzahl der abgespeicherten Objekte
    public int size(){
        return memberlist.size();
    }
    public List<Member> getCurrentList(){
        return memberlist;
    }
}
