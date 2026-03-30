package de.fhswf.inf.oop.aufgabe3.uebung2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String DESCRIPTION = "Wählen Sie:\nA: Kurse anzeigen\nN: Neuen Kurs anlegen\nL: Kurs löschen\nq: Beenden\n";

    public static void main(String[] args) {
        Map<String, String> courseMap = new HashMap<>();

        // Scannerobjekt für das Einlesen einer einzelnen und mehrerer Zeilen.
        Scanner scanner = new Scanner(System.console().reader());

        boolean canceled = false;
        System.out.println(DESCRIPTION);
        while (!canceled && scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "A":
                    System.out.println("Bitte Kurscode eingeben:");
                    scanner.hasNextLine();
                    String code = scanner.nextLine();
                    System.out.println("Bitte Kursname eingeben");
                    scanner.hasNextLine();
                    String name = scanner.nextLine();
                    String conf;
                    do {
                        System.out.printf("%s - %s übernehmen? y/n", code, name);
                        scanner.hasNextLine();
                        conf = scanner.nextLine();
                    } while (!conf.equals("y") || !conf.equals("n"));
                    if (conf.equals("y")) {

                    }
                    break;
                case "N":
                    break;
                case "L":
                    break;
                case "q":
                    canceled = true;
                    break;
                default:
                    System.out.printf("Ungültige Eingabe: \"%s\"\n", input);
                    break;
            }
            if (!canceled) {
                System.out.println(DESCRIPTION);
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
