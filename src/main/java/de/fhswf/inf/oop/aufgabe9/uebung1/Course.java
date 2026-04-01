package de.fhswf.inf.oop.aufgabe9.uebung1;

import java.util.regex.Pattern;

/**
 * Klasse für Datenobjekte für Kurse.
 *
 * @author M. Faulstich
 * @version v1
 */
public class Course implements Printable {
    public static final String DESCRIPTION = "Kursliste verwalten\nA: Kurse anzeigen\nN: Neuen Kurs anlegen\nS: Kurs suchen\nq: Abbrechen";
    public static final String TABLE_FORMAT = "%-20s %-20s %4d";
    public static final String TABLE_HEADER_FORMAT = "%-20s %-20s %4s";
    public static final String TABLE_HEADER = String.format(TABLE_HEADER_FORMAT, "Kursnummer", "Kursname", "ECTS");

    private String code;

    private String name;

    private int ects;

    /**
     * Initalisierungskonstruktor.
     *
     * @param code Kurs-Code. Siehe {@link #setCode(String)}.
     * @param name Name des Kurses. Siehe {@link #setName(String)}.
     * @param ects ECTS-Punkte des Kurses. Siehe {@link #setEcts(int)}.
     */
    public Course(String code, String name, int ects) {
        super();
        setCode(code);
        setName(name);
        setEcts(ects);
    }

    /**
     * Getter für den Code des Kurses.
     * 
     * @return Gibt den Code des Kurses zurück.
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter für den Code des Kurses.
     *
     * @param code
     *             Code des Kurses. Muss dem Muster AAA-MM-YYYY entsprechen: A:
     *             Großbuchstabe M: Monat mit führenden 0 Y: Jahr abe 1900
     * 
     * @throws IllegalArgumentException
     *                                  bei ungültigem Code.
     */
    public void setCode(String code) {
        if (!isValidCourseCode(code)) {
            throw new IllegalArgumentException(
                    "Erwarte gültigen Kurs-Code AAA-01-2020, ist aber " + code);
        }
        this.code = code;
    }

    /**
     * Getter für den Namen des Kurses.
     * 
     * @return Gibt den Namen des Kurses zurück.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter für den Namen des Kurses.
     *
     * @param name
     *             Der Name des Kurses. Darf nicht <code>null</code> oder leer
     *             sein oder nur aus Whitespace-Zeichen bestehen.
     * @throws IllegalArgumentException
     *                                  bei ungültigem Namen.
     */
    public void setName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException(String.format(
                    "Erwarte gültigen Namen fpr den Kurs, ist aber\"%s\"",
                    String.valueOf(name)));
        }
        this.name = name;
    }

    /**
     * Getter für die ECTS-Punte des Kurses.
     * 
     * @return Gibt die ECTS Punkte des Kurses zurück.
     */
    public int getEcts() {
        return ects;
    }

    /**
     * Setter für die ECTS-Punte des Kurses.
     *
     * @param ects
     *             ECTS-Punkte des Kurses. Dürfen nicht negativ sein.
     * @throws IllegalArgumentException
     *                                  bei negativen ECTS-Punkten.
     */
    public void setEcts(int ects) {
        if (ects < 0) {
            throw new IllegalArgumentException(
                    "Negative ECTS Punkte nicht erlaubt, übergeben wurden "
                            + ects);
        }
        this.ects = ects;
    }

    /**
     * Gibt das eine String-Repräsentation des {@link Course} Objekt zurück
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format(TABLE_FORMAT, getCode(), getName(), getEcts());
    }

    /**
     * Prüft einen übergebenen Kurs-Code auf Gültigkeit.
     * <p>
     * Ein gültiger Kurs-Code entspicht folgendem Muster: AAA-MM-YYYY.
     * <ul>
     * <li>A: Großbuchstaben A-Z</li>
     * <li>M: Monat 01-12 mit führenden Nullen.</li>
     * <li>Y: Jahr, 4-stellig, ab 1900 inclusive.</li>
     * </ul>
     * </p>
     *
     * @param courseCode Zu prüfender Kurs-Code.
     * @return <code>true</code>, wenn courseCode dem erwarteten Muster entspricht,
     *         sonst <code>false</code>.
     */
    private static boolean isValidCourseCode(String courseCode) {
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

    /**
     * Druckt das Objekt auf STDOU.
     */
    @Override
    public void print() {
        System.out.println(toString());
    }
}
