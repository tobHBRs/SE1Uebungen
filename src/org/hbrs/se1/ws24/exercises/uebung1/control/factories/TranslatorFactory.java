package org.hbrs.se1.ws24.exercises.uebung1.control.factories;

import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws24.exercises.uebung1.control.Translator;
//Vorteil der Factory Methode: Flexibel was die Erstellung von den Translatorn angeht, falls weitere erwünscht sind.
public class TranslatorFactory{
    public static Translator createGermanTranslator(){
        return new GermanTranslator();
    }
}
