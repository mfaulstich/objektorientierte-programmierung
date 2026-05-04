package de.fhswf.inf.oop.aufgabe8.uebung1.fahrzeuge;

public class PKW extends Fahrzeug {

    private Motor motor;
    private Fahrer fahrer;
    public PKW(String marke, int baujahr, Motor motor, Fahrer fahrer) {
        super(marke, baujahr);
        this.motor = motor;
        this.fahrer = fahrer;
    }

    @Override
    public int getServiceInterval(){
        return 12;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%s %s", super.toString(), motor.zuenden());
    }

    public String starten(){
        return motor.zuenden();
    }
}
