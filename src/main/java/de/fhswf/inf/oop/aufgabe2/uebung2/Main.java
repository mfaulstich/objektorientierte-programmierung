package de.fhswf.inf.oop.aufgabe2.uebung2;

public class Main {
	public static void main(String[] args) {
		int i = 1;
		Integer j = Integer.valueOf(1), k = Integer.valueOf(1);
		System.out.println(j); // Ausgabe: 1
		System.out.println(j == k); // Ausgabe: true
		System.out.println(j.equals(k)); // Ausgabe: true
		System.out.println(i == j); // Fehler beim Kompilieren
		System.out.println((i + "").equals(j + "")); // Fehler beim Kompilieren
	}
}
