package de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge;

public class E_PKW extends PKW {

    public E_PKW(String marke, int baujahr, Fahrer fahrer) {
        super(marke, baujahr, new Motor("Ssssssst"), fahrer);
    }

    @Override
    public String getAntrieb() {
        return "Elektromotor";
    }

}
