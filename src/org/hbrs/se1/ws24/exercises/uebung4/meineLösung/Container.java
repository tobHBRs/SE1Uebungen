package org.hbrs.se1.ws24.exercises.uebung4.meineLösung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
//Java singleton pattern: Stellt sicher das nur ein Object pro Klasse erzeugt werden kann, indem:
// --> der Konstruktor private gemacht wird = keine erzeugung von außen möglich
// --> das erzeugte Object als static Variable definiert ist
// --> statische getContainer Methode um auf die einzige Instanziierung des Objects zu zugreifen
public class Container<T extends Comparable<T>> {
    private static Container container;
    private PersistenceStrategy<T> persistenceStrategy; //Strategie für load/store

    ArrayList<T> list;
    private Container(){ //Privater Konstruktor verhindert erzeugung außerhalb der Klasse
        list = new ArrayList<T>();
        this.persistenceStrategy = new PersistenceStrategyStream<T>();
    }
    public static Container getContainer(){
        if(container == null){
            container = new Container();
        }
        return container;
    }
    public void setPersistenceStrategy(PersistenceStrategy<T> p){
        this.persistenceStrategy = p;
    }

    public void store() throws PersistenceException{
        if(persistenceStrategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NullPointer, "Keine Strategy ausgewählt");
        }
        persistenceStrategy.save(list);
    }

    public void load() throws PersistenceException, org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException {
        if(persistenceStrategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NullPointer, "Keine Strategy ausgewählt");
        }
        list = (ArrayList<T>) persistenceStrategy.load();

    }

    public void addUserStory(T a) throws ContainerException {
        if (list.contains(a)) {
            ContainerException ex = new ContainerException("User Story bereits vorhanden!");
            throw ex;
        }
        list.add(a);
    }

    public void deleteUserStory(T a) throws ContainerException {
        if (!list.contains(a)){
            ContainerException ex = new ContainerException("User Story nicht vorhanden!");
            throw ex;
        }
        list.remove(a);
    }
    public void dump(){
        Collections.sort(this.list);
        for (T item : list) {
            System.out.println(item);
        }
    }
    public int size(){
        return list.size();
    }
    public List<T> getCurrentList(){
        return list;
    }
    Scanner sc = new Scanner(System.in);
    public void startEingabe() throws ContainerException, PersistenceException, org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException {
        String strInput = null;
        System.out.println("Bitte Befehl eingeben");
        boolean running = true;
        while(running){
            System.out.print("> ");
            strInput = sc.nextLine();

            String[] strings = strInput.split(" ");
            if(strings[0].equals("help")){
                System.out.println("Mögliche Befehle: help,store, load, dump,exit, enter (Bitte in Folgender Reihenfolge angeben: ID,Title,Akzeptanzbedingung,Projekt,Mehrwert,Strafe,Aufwand,Risiko)");
            }

            if(strings[0].equals("enter")){
                container.addUserStory(new UserStory(Integer.parseInt(strings[1]),strings[2],strings[3],strings[4],
                        Double.parseDouble(strings[5]),Double.parseDouble(strings[6]),Double.parseDouble(strings[7]),Double.parseDouble(strings[8])));
            }

            if(strings[0].equals("store")){
                container.store();
            }

            if(strings[0].equals("load")){
                container.load();
            }

            if(strings[0].equals("exit")){
                running = false;
            }

            if(strings[0].equals("dump")){
                container.dump();
            }
        }
    }
}
