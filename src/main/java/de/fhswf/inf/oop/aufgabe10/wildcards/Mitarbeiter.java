package de.fhswf.inf.oop.aufgabe10.wildcards;

public class Mitarbeiter extends Person {
    private final int personalNummer;
    public Mitarbeiter(String name, int personalNummer) {
        super(name);
        this.personalNummer = personalNummer;
    }
}
