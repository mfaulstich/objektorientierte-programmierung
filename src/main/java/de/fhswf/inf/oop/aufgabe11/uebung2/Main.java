package de.fhswf.inf.oop.aufgabe11.uebung2;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		System.out.println("=== AUFGABE 2: Functional Interfaces ===");

		// Bedingungen als Predicates definieren
		Predicate<String> hatMindestLaenge = (String text) -> text != null && text.length() >= 5;
		Predicate<String> hatSonderzeichen = (String text) -> text.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

		// Logische Verknüpfung der Predicates via Default-Methode .and()
		Predicate<String> istValidesPasswort = hatMindestLaenge.and(hatSonderzeichen);

		// Transformation via Function: Zensiert den Text (nur erstes/letztes Zeichen
		// lesbar)
		Function<String, String> textVerschluesseln = (String text) -> {
			if (text == null || text.length() <= 2)
				return "***";
			return text.charAt(0) + "*".repeat(text.length() - 2) + text.charAt(text.length() - 1);
		};

		// Testläufe über die flexible Verarbeitungsmethode
		verarbeiteEingabe("abc", istValidesPasswort, textVerschluesseln);
		verarbeiteEingabe("geheimnis", istValidesPasswort, textVerschluesseln);
		verarbeiteEingabe("S1ch3r!", istValidesPasswort, textVerschluesseln);
		System.out.println();
	}

	/**
	 * Übergabemethode für funktionale Interfaces aus Aufgabe 2. Typsicher, flexibel
	 * austauschbar und entkoppelt von konkreten Implementierungen.
	 */
	private static void verarbeiteEingabe(String eingabe, Predicate<String> validierungsLogik,
			Function<String, String> transformationsLogik) {
		System.out.print("Prüfe \"" + eingabe + "\": ");

		// Auswertung mittels .test()
		if (validierungsLogik.test(eingabe)) {
			// Transformation mittels .apply()
			String ergebnis = transformationsLogik.apply(eingabe);
			System.out.println("ZULÄSSIG -> " + ergebnis);
		} else {
			System.out.println("ABGEWIESEN (Erfüllt Sicherheitsrichtlinien nicht)");
		}
	}

}
