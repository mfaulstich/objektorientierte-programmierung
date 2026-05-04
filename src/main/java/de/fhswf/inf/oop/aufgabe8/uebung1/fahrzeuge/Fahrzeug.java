package de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge;

public class Fahrzeug {
    private static final String FORMAT = "%s, %s, %d";
    private final String marke;
    private int baujahr;
    private static int count;

    public Fahrzeug(String marke, int baujahr){
        this.marke = marke;
        this.baujahr = baujahr;
        count++;
    }

    @Override
    public String toString(){
        return String.format(FORMAT, getClass().getSimpleName(), marke, baujahr);
    }

    protected int getServiceInterval(){
        return 0;
    }

    public String getAntrieb(){
        return "Unbekannt";
    }

    public static int getCount(){
        return count;
    }
}
