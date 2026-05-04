package de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge;

public class Verbrenner extends PKW{

    public Verbrenner(String marke, int baujahr, Fahrer fahrer) {
        super(marke, baujahr, new Motor("Rrrrrööööhhrrr"), fahrer);
    }

    @Override
    public String getAntrieb() {
        return "E-Motor";
    }

}
