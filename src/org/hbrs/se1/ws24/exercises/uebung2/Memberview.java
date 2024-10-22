package org.hbrs.se1.ws24.exercises.uebung2;

import java.util.List;

public class Memberview {
    public void dump(List<Member> liste){ //dump Methode in eigene Klasse gemoved mit zugriff auf container.getCurrentList()
        for(Member m : liste){
            System.out.println(m.toString());
        }
    }
}
