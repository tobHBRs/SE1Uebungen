package org.hbrs.se1.ws24.exercises.uebung3.test;

import org.hbrs.se1.ws24.exercises.uebung2.*;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTestNew {
    private PersistenceStrategyStream<Member> stream;
    private PersistenceStrategyMongoDB<Member> mongo;
    private Container container;
    @BeforeEach
    void init(){
        container = Container.getContainer();
    }
    @Test
    public void RoundTripTest() throws ContainerException, PersistenceException {
        Member m1 = new ConcreteMember(1);
        Member m2 = new ConcreteMember(2);

        container.addMember(m1);
        container.addMember(m2);
        assertEquals(2,container.size());
        stream = new PersistenceStrategyStream<>();
        container.setPersistenceStrategy(stream);
        container.store();

        container.deleteMember(1);
        container.deleteMember(2);
        assertEquals(0,container.size());

        container.load();
        assertEquals(2,container.size());
    }
    @Test
    public void StrategieTest() {
        assertThrows(PersistenceException.class,container::store);
    }
    @Test
    public void PersistenceStrategieMongoDBTest(){
        mongo = new PersistenceStrategyMongoDB<>();
        container.setPersistenceStrategy(mongo);
        assertThrows(UnsupportedOperationException.class, container::store);
    }
    @Test
    public void TestLocation(){
        stream = new PersistenceStrategyStream<>();
        stream.setLocation("/does/not/exist");
        container.setPersistenceStrategy(stream);
        assertThrows(PersistenceException.class,container::store);
    }
}
