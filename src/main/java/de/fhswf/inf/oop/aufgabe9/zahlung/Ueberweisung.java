package de.fhswf.inf.oop.aufgabe9.zahlung;

public class Ueberweisung extends Transaction {
    public Ueberweisung(String id, double betrag) {
        super(id, betrag);
    }

    @Override
    public void ausfuehren() {
        System.out.printf("Führe %s.ausfuehren() aus mit einem Betrag von %.2f\n", getClass().getSimpleName(), getBetrag());
    }
}
