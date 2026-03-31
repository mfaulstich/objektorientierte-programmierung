package de.fhswf.inf.oop.aufgabe3.uebung1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    private static final String DESCRIPTION = "Kursliste verwalten\nA: Kurse anzeigen\nN: Neuen Kurs anlegen\nS: Kurs suchen\nq: Abbrechen\n";
    private static final String TABLE_FORMAT = "%-20s %-20s\n";

    public static void main(String[] args) {
        Map<String, String> coures = new TreeMap<>();
        // Scannerobjekt für das Einlesen einer einzelnen und mehrerer Zeilen.
        Scanner scanner = new Scanner(System.console().reader());
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
                        System.out.printf(TABLE_FORMAT, "Kursnummer", "Kursname");
                        for (Map.Entry<String, String> course : coures.entrySet()) {
                            System.out.printf(TABLE_FORMAT, course.getKey(), course.getValue());
                        }
                    }
                    break;
                case "N":
                    /*
                     * Kurscode einlesen
                     */
                    System.out.println("Bitte geben Sie einen Kurscode ein:");
                    scanner.hasNextLine();
                    String code = scanner.nextLine();
                    if (code.trim().isEmpty()) {
                        System.out.printf("Die Eingabe \"%s\" ist keine gültiger Kursname!\n", code);
                        break;
                    }

                    /*
                     * Kursname einlesen
                     */
                    System.out.println("Bitte geben Sie einen Kursnamen ein:");
                    scanner.hasNextLine();
                    String name = scanner.nextLine();
                    if (name.trim().isEmpty()) {
                        System.out.printf("Die Eingabe \"%s\" ist keine gültiger Kursname!\n", name);
                        break;
                    }

                    /*
                     * Bestätigung der Eingabe
                     */
                    String selection;
                    do {
                        System.out.println("Kurs anlegen? j/n:");
                        System.out.printf(TABLE_FORMAT, code, name);
                        scanner.hasNextLine();
                        selection = scanner.nextLine();
                        if (!(selection.equals("j") || selection.equals("n"))) {
                            System.out.printf("Die Eingabe \"%s\" keine gültige Auswahl!\n", selection);
                        }
                    } while (!(selection.equals("j") || selection.equals("n")));
                    if (selection.equals("j")){
                        coures.put(code, name);
                    }
                    break;
                case "S":
                    System.out.println("Bitte geben Sie einen Kurscode ein:");
                    scanner.hasNextLine();
                    code = scanner.nextLine();
                    if (code.trim().isEmpty()) {
                        System.out.printf("Die Eingabe \"%s\" ist keine gültiger Kurscode!\n", code);
                    } else {
                        name = coures.get(code);
                        if (name == null){
                        System.out.printf("Ein Kurs mit dem Code \"%s\" ist nicht vorhanden\n", code);
                        }
                        else {
                            System.out.println("Kurs gefunden:");
                            System.out.printf(TABLE_FORMAT, code, name);
                        }
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
