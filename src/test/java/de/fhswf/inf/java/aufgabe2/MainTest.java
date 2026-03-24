package de.fhswf.inf.java.aufgabe2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    @DisplayName("Prüfe die Antwort auf die endgültige Frage nach dem Leben, dem Universum und dem ganzen Rest")
    public void testTheAnswerToLifeTheUniverseAndEverything() {
        assertEquals(42, Main.testTheAnswerToLifeTheUniverseAndEverything(), "Die Antwort muss 42 sein!");
    }

}
