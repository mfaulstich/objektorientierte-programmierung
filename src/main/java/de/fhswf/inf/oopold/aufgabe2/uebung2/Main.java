package de.fhswf.inf.oopold.aufgabe2.uebung2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DESCRIPTION = "Kursliste verwalten\nA: Kurse anzeigen\nN: Neuen Kurs anlegen\nS: Kurs suchen\nq: Abbrechen\n";

    public static void main(String[] args) {
        List<String> coures = new ArrayList<>();
        // Scannerobjekt für das Einlesen einer einzelnen und mehrerer Zeilen.
        try (Scanner scanner = new Scanner(System.console().reader())) {
            boolean canceled = false;
            System.out.println(DESCRIPTION);
            while (!canceled && scanner.hasNextLine()) {
                String input = scanner.nextLine();
                switch (input) {
                    case "q":
                        canceled = true;
                        break;
                    case "A":
                        if (coures.size() == 0) {
                            System.out.println("Leider können wir zur Zeit keine Kurse anbieten.");
                        } else {
                            System.out.println("User Kursangebot:");
                            Collections.sort(coures);
                            for (String course : coures) {
                                System.out.println(course);
                            }
                        }
                        break;
                    case "N":
                        System.out.println("Bitte geben Sie einen Kursnamen ein:");
                        scanner.hasNextLine();
                        String name = scanner.nextLine();
                        if (name.trim().isEmpty()) {
                            System.out.printf("Die Eingabe \"%s\" ist keine gültiger Kursname!\n", name);
                        } else {
                            coures.add(name);
                        }
                        break;
                    case "S":
                        System.out.println("Bitte geben Sie einen Kursnamen ein:");
                        scanner.hasNextLine();
                        name = scanner.nextLine();
                        if (name.trim().isEmpty()) {
                            System.out.printf("Die Eingabe \"%s\" ist keine gültiger Kursname!\n", name);
                        } else {
                            System.out.printf("Kurs \"%s\" ist %s\n", name,
                                    coures.contains(name) ? "vorhanden" : "nicht vorhanden");
                        }
                        break;
                    default:
                        System.out.printf("Ungültige Eingabe: \"%s\"\n", input);
                        break;
                }
                if (!canceled) {
                    System.out.println();
                    System.out.println(DESCRIPTION);
                }
            }
        }
    }
}
