package de.fhswf.inf.oop.aufgabe11.uebung3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	record Product(String name, String category, double price) {
	}

	public static void main(String[] args) {
		System.out.println("=== AUFGABE 3: Komplexe Collectors ===");

		List<Product> produkte = List.of(new Product("Laptop", "Elektronik", 1200.00),
				new Product("Smartphone", "Elektronik", 800.00), new Product("Kaffeemaschine", "Küche", 150.00),
				new Product("Messer-Set", "Küche", 89.00), new Product("Roman", "Bücher", 14.99),
				new Product("Fachbuch", "Bücher", 49.99));

		// Teilschritt 1: Gruppierung nach Kategorie
		Map<String, List<Product>> nachKategorie = produkte.stream()
				.collect(Collectors.groupingBy((Product p) -> p.category()));
		System.out.println("1. Produkte nach Kategorie: " + nachKategorie);

		// Teilschritt 2: Anzahl pro Kategorie zählen via Downstream-Collector
		Map<String, Long> anzahlProKategorie = produkte.stream()
				.collect(Collectors.groupingBy((Product p) -> p.category(), Collectors.counting()));
		System.out.println("2. Anzahl pro Kategorie: " + anzahlProKategorie);

		// Teilschritt 3: Teuerstes Produkt per Stream-Reduktion / Comparator
		Optional<Product> teuerstesProdukt = produkte.stream()
				.max(Comparator.comparingDouble((Product p) -> p.price()));

		teuerstesProdukt.ifPresent(
				(Product p) -> System.out.println("3. Teuerstes Produkt: " + p.name() + " (" + p.price() + " €)"));
		System.out.println();
	}

}
