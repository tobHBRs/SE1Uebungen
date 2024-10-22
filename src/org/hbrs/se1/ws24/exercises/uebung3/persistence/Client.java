package org.hbrs.se1.ws24.exercises.uebung3.persistence;

import org.hbrs.se1.ws24.exercises.uebung2.*;

public class Client {
    public static void main(String[] args) throws ContainerException {
        Container container = Container.getContainer();
        ConcreteMember m1 = new ConcreteMember(1);
        ConcreteMember m2 = new ConcreteMember(2);
        container.addMember(m1);
        container.addMember(m2);
        Memberview memberview = new Memberview();
        memberview.dump(container.getCurrentList());
    }

}
