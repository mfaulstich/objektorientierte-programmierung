package de.fhswf.inf.oop.aufgabe3.uebung4;

public class Main {
	public static void main(String[] args) {
		boolean bedingung1;
		boolean bedingung2;
		boolean bedingung3;

		int count = 0;
		while (count < 8) {
			bedingung1 = (count & 1) != 0;
			bedingung2 = (count & 2) != 0;
			bedingung3 = (count & 4) != 0;
			System.out.printf("Bedingungen: %d, %d, %d\n", bedingung1 ? 1 : 0, bedingung2 ? 1 : 0, bedingung3 ? 1 : 0);

			System.out.println("Vorgabe:");
			if (bedingung1)
				if (bedingung2)
					if (bedingung3)
						System.out.println("Ausgabe 1");
					else
						;
				else
					;
			else if (bedingung2)
				if (bedingung3)
					System.out.println("Ausgabe 2");
				else
					System.out.println("Ausgabe 3");
			else
				;

			System.out.println("Optimierung:");
			if (bedingung2) {
				if (bedingung1) {
					if (bedingung3)
						System.out.println("Ausgabe 1");
				} else {
					if (bedingung3)
						System.out.println("Ausgabe 2");
					else
						System.out.println("Ausgabe 3");
				}
			}
			
			System.out.println();
			count++;
		}
	}
}
