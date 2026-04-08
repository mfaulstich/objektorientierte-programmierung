package de.fhswf.inf.oop.aufgabe3.uebung1;

public class Main {
	public static void main(String[] args) {
		/*
		 * Vorgabe
		 */
		int count = 10;
		while (count > 0) {
			if (count-- > 5)
				continue;
			System.out.println(count);
		}

		/*
		 * Lösung
		 */
		count = 10;
		while (count > 0) {
			if (count-- <= 5) {
				System.out.println(count);
			}
		}
	}
}
