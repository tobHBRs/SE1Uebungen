package org.hbrs.se1.ws24.tests.uebung1;
import static org.junit.jupiter.api.Assertions.*;
import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

public class GermanTranslatorTest {

    @Test
    public void NullTest() { //Null als Grenzwert testen
        GermanTranslator translator = new GermanTranslator();

        assertEquals("Übersetzung der Zahl 0 nicht möglich (1.0)" , translator.translateNumber(0));
    }
    @Test
    public void Pos1Test() { //Positive Zahlen im Definitionsbereich
        GermanTranslator translator = new GermanTranslator();

        assertEquals("fünf" , translator.translateNumber(5));
    }
    @Test
    public void NegTest1() { //Negative Zahlen testen
        GermanTranslator translator = new GermanTranslator();

        assertEquals("Übersetzung der Zahl -1 nicht möglich (1.0)" , translator.translateNumber(-1));
    }
    @Test
    public void Neg2Test() { //Positive Zahlen außerhalb des Definitionsbereichs testen
        GermanTranslator translator = new GermanTranslator();

        assertEquals("Übersetzung der Zahl 11 nicht möglich (1.0)" , translator.translateNumber(11));
    }


}
