package de.fhswf.inf.oop.aufgabe11.uebung4;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		System.out.println("=== AUFGABE 4: Primitive Streams ===");

		// Datenquelle erzeugen (1 bis 100.000 ohne rechenintensives Autoboxing)
		IntStream zahlenStream = IntStream.rangeClosed(1, 100_000);

		// Datenströme filtern und mittels summaryStatistics auswerten
		IntSummaryStatistics stats = zahlenStream.filter((int n) -> n % 2 == 0) // Ausschließlich gerade Zahlen
				.summaryStatistics(); // Aggregiert count, sum, min, max, average in einem Durchlauf

		System.out.println("Anzahl gerader Zahlen: " + stats.getCount());
		System.out.println("Summe aller geraden Zahlen: " + stats.getSum());
		System.out.println("Mathematischer Durchschnitt: " + stats.getAverage());

		// Optionaler Performance-Check mit parallelisierten Strömen bei 10 Millionen
		// Zahlen
		long startzeit = System.nanoTime();
		long summeParallel = IntStream.rangeClosed(1, 10_000_000).parallel().filter((int n) -> n % 2 == 0).sum();
		long endzeit = System.nanoTime();

		System.out.println("Parallele Summe (1 bis 10 Mio) berechnet in: " + (endzeit - startzeit) / 1_000_000 + " ms");

	}

}
