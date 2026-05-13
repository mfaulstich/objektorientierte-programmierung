package de.fhswf.inf.oop.aufgabe10.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		  // Quelle: Spezifische Mitarbeiter-Liste
        List<Mitarbeiter> team = List.of(
            new Mitarbeiter("Müller", 1001),
            new Mitarbeiter("Schmidt", 1002)
        );
        
        // Ziel: Allgemeine Personen-Liste
        List<Person> firmenKartei = new ArrayList<>();
        
        // Der Transfer funktioniert nur wegen den Wildcards!
        Util.transfer(team, firmenKartei);
        
        System.out.println(firmenKartei);

	}

}
