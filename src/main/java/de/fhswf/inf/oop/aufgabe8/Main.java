package de.fhswf.inf.oop.aufgabe8;

import de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge.PKW;
import de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge.Verbrenner;
import de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge.E_PKW;
import de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge.Fahrer;
import de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge.Fahrzeug;
import de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge.Motor;

public class Main {
    public static void main(String[] args) {

        /*
         * Übung 1
         */
        Fahrer fahrer = new Fahrer();
        Fahrzeug f1 = new Fahrzeug("VW", 2025);
        Fahrzeug f2 = new Fahrzeug("Audi", 2023);
        Fahrzeug f3 = new PKW("Opel", 2023, new Motor("Frrrrr"), fahrer);
        Fahrzeug f4 = new PKW("Renault", 2023, new Motor("Frrrrr"), fahrer);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);

        // new Fahrzeug("KIA", 2019).getServiceInterval();
        new PKW("KIA", 2019, new Motor("Brummm"), fahrer).getServiceInterval();

        System.out.println(new E_PKW("VW", 2026, fahrer).getAntrieb());
        System.out.println(new Verbrenner("VW", 2026, fahrer).getAntrieb());

        System.out.printf("Fahrzeuge anglegt: %3d\n", Fahrzeug.getCount());

        System.out.print("Starte..  " + ((PKW)f4).starten());
    }
}
