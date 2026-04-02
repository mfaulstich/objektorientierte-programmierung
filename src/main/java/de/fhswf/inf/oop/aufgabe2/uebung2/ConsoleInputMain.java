package de.fhswf.inf.oop.aufgabe2.uebung2;

import java.util.Scanner;

public class ConsoleInputMain {
    private static final String DESCRIPTION = "Geben Sie etwas ein und drücken Sie \"Enter\". Abbruch mit \"q\"";

    public static void main(String[] args) {

        // Scannerobjekt für das Einlesen einer einzelnen und mehrerer Zeilen.

        // Das Scanner-Objekt muss in jedem Fall geschlossen werden, auch wenn eine Exception einen Programm-Abbruch erzwingt.
        // Daher ein try-finally-Block, dessen finally-Teil auch bei Exceptions im try-Block ausgeführt wird.
        // Um im finally-Block auf die Variable scanner noch zugreifen zu können (lokale Variablen sind nur innerhalb 
        // ihres Blocks gültig) wird die Variable vor dem try-Block definiert.
        Scanner scanner = null;
        try {
            // Scanner Objekt wird zum Lesen von der Console instanziiert.
            scanner = new Scanner(System.console().reader());

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
        } finally {
            // Scanner-Objekt wird geschlossen, wenn die Instaziierung ein gültiges Objekt zurückgegeben hat.
            if (scanner != null) {
                scanner.close();
            }
        }

        /*
         * Optionaler Indikator, dass das Programm wirklich durchgelaufen und beendet
         * ist.
         */
        System.out.println();
        System.out.println("Done!");
    }
}
