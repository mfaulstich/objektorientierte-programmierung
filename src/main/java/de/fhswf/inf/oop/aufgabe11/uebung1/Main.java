package de.fhswf.inf.oop.aufgabe11.uebung1;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		System.out.println("=== AUFGABE 1: Stream-Pipeline ===");

		List<String> namen = List.of("Anna", "  bob ", "Alex", "Dieter", "ANTON", "anna", "alex");

		// Erstellung der Pipeline mit expliziten Lambda-Typen
		List<String> bereinigteNamen = namen.stream().map((String s) -> s.trim()) // Leerzeichen entfernen
				.filter((String s) -> s.toLowerCase().startsWith("a")) // Nur Namen mit 'A'/'a'
				.map((String s) -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase()) // In
																									// Standard-CamelCase
																									// umwandeln
				.distinct() // Duplikate eliminieren
				.sorted() // Alphabetisch sortieren
				.collect(Collectors.toList()); // In Ergebnisliste sammeln

		System.out.println("Ergebnis Aufgabe 1: " + bereinigteNamen);
		System.out.println();
	}

}