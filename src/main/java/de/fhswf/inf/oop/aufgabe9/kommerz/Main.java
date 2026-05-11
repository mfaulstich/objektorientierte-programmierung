package de.fhswf.inf.oop.aufgabe9.kommerz;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Kreditkarte("1", 23.50).ausfuehren();
        new Ueberweisung("2", 44.30).ausfuehren();
        new WarenBestellung("3", 56.69).verpacken();

        Sonderbestellung sonderBestellung = new Sonderbestellung();
        System.out.printf("Rabatt für %s: %.2f\n", sonderBestellung.getClass().getSimpleName(), sonderBestellung.holeRabatt());


        new  Kreditkarte(null, 0.0);
    }
}
