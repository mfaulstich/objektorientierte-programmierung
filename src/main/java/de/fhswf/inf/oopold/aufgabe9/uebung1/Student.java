package de.fhswf.inf.oopold.aufgabe9.uebung1;

import java.util.regex.Pattern;

import de.fhswf.inf.oopold.aufgabe5.uebung1.Person;

/**
 * Student.
 */
public class Student extends Person implements Printable {
    private static final Pattern MATRICULATION_PATTERN = Pattern.compile("^[0-9]{8}$");
    private String matriculationNumber;

    /**
     * Initialisierungskonstruktor.
     * 
     * @param name                Siehe {@link Person#Person(String, int)}.
     * @param age                 Siehe {@link Person#Person(String, int)}.
     * @param matriculationNumber Siehe {@link #setMatriculationNumber(String)}.
     */
    public Student(String name, int age, String matriculationNumber) {
        super(name, age);
        setMatriculationNumber(matriculationNumber);
    }

    /**
     * Setter für die Matrikelnummer.
     * 
     * @param matriculationNumber Gültige Matrikelnummer bestehend aus 8 Ziffern.
     * @throws IllegalArgumentException bei ungültiger Matrikelnummer.
     */
    public void setMatriculationNumber(String matriculationNumber) {
        if (matriculationNumber == null || !MATRICULATION_PATTERN.matcher(matriculationNumber).matches()) {
            throw new IllegalArgumentException(
                    String.format("Erwarte gültige Matrikelnummer aus 8 Ziffern, ist aber \"%s\"",
                            String.valueOf(matriculationNumber)));
        }
        this.matriculationNumber = matriculationNumber;
    }

    /**
     * Getter für die Matrikelnummer.
     * 
     * @return Matrikelnummer des Studenten.
     */
    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    /**
     * Gibt die Daten des Studenten als String zurück.
     */
    @Override
    public String toString() {
        return super.toString() + " Mat.Nr. " + getMatriculationNumber();
    }

    /**
     * Druckt das Objekt auf STDOU.
     */
    @Override
    public void print() {
        System.out.println(toString());
    }

}
