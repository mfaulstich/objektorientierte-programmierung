package de.fhswf.inf.oopold.aufgabe4.uebung1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {
    private static final String DESCRIPTION = "Kursliste verwalten\nA: Kurse anzeigen\nN: Neuen Kurs anlegen\nS: Kurs suchen\nq: Abbrechen\n";
    private static final String TABLE_FORMAT = "%-20s %-20s %4d\n";
    private static final String TABLE_HEADER_FORMAT = "%-20s %-20s %4s\n";
    private static final String TABLE_HEADER = String.format(TABLE_HEADER_FORMAT, "Kursnummer", "Kursname", "ECTS");

    public static void main(String[] args) {
        Map<String, String> coures = new TreeMap<>();
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
                            System.out.printf(TABLE_HEADER);
                            for (Map.Entry<String, String> course : coures.entrySet()) {
                                System.out.printf(TABLE_FORMAT, course.getKey(), course.getValue(),
                                        calculateECTS(course.getKey()));
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
                        if (!isValidCourseCode(code)) {
                            System.out.printf("Die Eingabe \"%s\" ist keine gültiger Kursname!\n", code);
                            break;
                        }
                        if (coures.containsKey(code)) {
                            System.out.printf("Ein Kurs mit dem Kurscode \"%s\" ist bereits vorhanden!\n", code);
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
                            System.out.printf(TABLE_HEADER);
                            System.out.printf(TABLE_FORMAT, code, name, calculateECTS(code));
                            scanner.hasNextLine();
                            selection = scanner.nextLine();
                            if (!(selection.equals("j") || selection.equals("n"))) {
                                System.out.printf("Die Eingabe \"%s\" keine gültige Auswahl!\n", selection);
                            }
                        } while (!(selection.equals("j") || selection.equals("n")));
                        if (selection.equals("j")) {
                            coures.put(code, name);
                        }
                        break;
                    case "S":
                        System.out.println("Bitte geben Sie einen Kurscode ein:");
                        scanner.hasNextLine();
                        code = scanner.nextLine();
                        if (!isValidCourseCode(code)) {
                            System.out.printf("Die Eingabe \"%s\" ist keine gültiger Kurscode!\n", code);
                        } else {
                            name = coures.get(code);
                            if (name == null) {
                                System.out.printf("Ein Kurs mit dem Code \"%s\" ist nicht vorhanden\n", code);
                            } else {
                                System.out.println("Kurs gefunden:");
                                System.out.printf(TABLE_HEADER);
                                System.out.printf(TABLE_FORMAT, code, name, calculateECTS(code));
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

    public static boolean isValidCourseCode(String courseCode) {
        if (courseCode == null) {
            throw new IllegalArgumentException("Ungültige null-Referenz");
        }
        // 3 Grossbuchstaben am Anfang
        Pattern pattern = Pattern.compile("^[A-Z]{3}-.*");
        if (!pattern.matcher(courseCode).matches()) {
            return false;
        }

        // 3 Blöcke, durch - getrennt
        String[] items = courseCode.split("-");
        if (items.length != 3) {
            return false;
        }

        // Block 2: 01-12
        if (items[1].length() != 2) {
            return false;
        }
        try {
            int month = Integer.parseInt(items[1]);
            if (month < 1 || month > 12) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        // Block 3; 1900 bis 9999
        if (items[2].length() != 4) {
            return false;
        }
        try {
            int year = Integer.parseInt(items[2]);
            if (year < 1900) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static int calculateECTS(String couseCode) {
        if (!isValidCourseCode(couseCode)) {
            throw new IllegalArgumentException("Ungültiger Kurs-Code: " + couseCode);
        }
        String[] items = couseCode.split("-");
        int sum = 0;
        for (int idx = 0; idx < items[0].length(); idx++) {
            sum += items[0].charAt(idx);
        }
        return sum;
    }
}
