package de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge;

public class Motor {
    private String geraeusch;

    public Motor(String geraeusch) {
        this.geraeusch = geraeusch;
    }

    String zuenden() {
        return geraeusch;
    }
}
