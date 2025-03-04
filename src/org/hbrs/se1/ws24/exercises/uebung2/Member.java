package org.hbrs.se1.ws24.exercises.uebung2;

import org.junit.jupiter.api.BeforeEach;

public interface Member {

    /**
     * Die ID ist über einen Konstruktor einer Klasse, welches dieses Interface implementiert,
     * zu setzen. Die ID darf nicht innerhalb des Container-Objekts gesetzt werden.
     * Die ID dient als Primärschlüssel zur Unterscheidung aller Member-Objekte.
     */
    
    public Integer getID();
}
