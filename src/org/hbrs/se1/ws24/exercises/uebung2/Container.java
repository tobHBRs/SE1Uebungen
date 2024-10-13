package org.hbrs.se1.ws24.exercises.uebung2;
import java.util.ArrayList;
public class Container {
    ArrayList<Member> memberlist;
    public Container(){
        memberlist = new ArrayList<Member>();
    }
    //FA1 hinzufügen des Member Objects und überprüft ob es bereits vorhanden ist
    public void addMember(Member n) throws ContainerException{
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
    public void dump(){
        for(Member m : memberlist){
            System.out.println(m.toString());
        }
    }
    //FA4 Anzahl der abgespeicherten Objekte
    public int size(){
        return memberlist.size();
    }
}
