package de.fhswf.inf.oop.aufgabe2.uebung1;

import java.util.Scanner;

public class ConsoleInputMain {
    private static final String DESCRIPTION = "Geben Sie etwas ein und drücken Sie \"Enter\". Abbruch mit \"q\"";

    public static void main(String[] args) {

        // Scannerobjekt für das Einlesen einer einzelnen und mehrerer Zeilen.
        Scanner scanner = new Scanner(System.console().reader());

        /*
         * Einlesen einer einzelnen Eingabe über die Konsole
         */
        System.out.println("Geben Sie irgend etwas ein und drücken Sie \"Enter\"");
        scanner.hasNextLine(); // Wartet, bis eine Eingabe erfolgt und mit Enter abgeschlossen ist.
        System.out.println("Zeile eingelesen");
        System.out.println(scanner.nextLine());

        // Trennzeilen einfügen
        System.out.println();
        System.out.println();

        /*
         * Schlefe zum Wiederholten Einlesen von der Konsole und speichern in einer
         * Liste. Abbruch mit "q"
         */
        boolean canceled = false;
        System.out.println(DESCRIPTION);
        while (!canceled && scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "q":
                    canceled = true;
                    break;
                default:
                    System.out.printf("Eingabe: \"%s\"\n", input);
                    break;
            }
            if (!canceled) {
                System.out.println(DESCRIPTION);
            }
        }

        /*
         * Optionaler Indikator, dass das Programm wirklich durchgelaufen und beendet ist.
         */
        System.out.println();
        System.out.println("Done!"); 
    }
}
 
