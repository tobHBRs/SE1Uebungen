package org.hbrs.se1.ws24.exercises.uebung2.test;
import org.hbrs.se1.ws24.exercises.uebung2.*;
import org.junit.jupiter.api.*;
//Imports um Methode dump() zu testen:
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class ContainerTest {
    Container c;
    @BeforeEach
    public void init() throws ContainerException {
        c = new Container();
        Member m1 = new ConcreteMember(1);
        Member m2 = new ConcreteMember(2);
        c.addMember(m1);
        c.addMember(m2);
    }
    @Test
    public void testAddMember() throws ContainerException {
        //Pos addMember() test
        Member m3 = new ConcreteMember(3);
        c.addMember(m3);
        assertEquals(3,c.size());
        //Neg addMember() test mit bereits vorhandener ID
        Member m4 = new ConcreteMember(3);
        assertThrows(ContainerException.class,() -> c.addMember(m4));
    }
    @Test
    public void testDeleteMember(){
        //Pos deleteMember() test
        c.deleteMember(2);
        assertEquals(1,c.size());
        //Neg deleteMember() test keine ID gefunden
        assertEquals("Fehler: Member mit der ID " + 2 + " konnte nicht gefunden werden.",c.deleteMember(2));
        //Neg deleteMember() test size = 0
        c.deleteMember(1);
        assertEquals("Fehler: Member mit der ID " + 1 + " konnte nicht gefunden werden.",c.deleteMember(1));
    }
    @Test
    public void testMoreAdditions() throws ContainerException {
        Member m3 = new ConcreteMember(3);
        c.addMember(m3);
        Member m4 = new ConcreteMember(4);
        c.addMember(m4);
        Member m5 = new ConcreteMember(5);
        c.addMember(m5);
        assertEquals(5,c.size());
    }
    @Test
    public void testMoreDeletions() throws ContainerException {
        Member m3 = new ConcreteMember(3);
        c.addMember(m3);
        c.deleteMember(1);
        c.deleteMember(2);
        c.deleteMember(3);
        assertEquals(0,c.size());
    }
    @Test
    public void testAddAndDeleteSameMember() throws ContainerException {
        Member m3 = new ConcreteMember(3);
        c.addMember(m3);
        c.deleteMember(3);
        assertEquals(2,c.size());
    }
    @Test
    public void testContainerIsEmpty(){
        Container a = new Container();
        assertEquals(0,a.size());
    }
    @Test
    public void testNull() throws ContainerException {
        try {
            c.addMember(null);
        } catch(NullPointerException e){

        }

    }

}
