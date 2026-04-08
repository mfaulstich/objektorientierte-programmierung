package de.fhswf.inf.oop.aufgabe3.uebung2;

public class Main {
	public static void main(String[] args) {
		/*
		 * Vorgabe
		 */
		int count = 10;
		do {

			if (!(count >= 0)) {
				continue;
			} else {
				System.out.println(count);
			}
			count--;

		} while (count >= 0);

		/*
		 * Lösung
		 */
		count = 10;
		while (count >= 0) {
			System.out.println(count);
			count--;
		}
	}
}
