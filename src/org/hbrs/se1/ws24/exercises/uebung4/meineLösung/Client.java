package org.hbrs.se1.ws24.exercises.uebung4.meineLösung;


public class Client {
    public static void main(String[] args) throws ContainerException, PersistenceException, org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException {
        Container container = Container.getContainer();
        container.startEingabe();

    }
}
