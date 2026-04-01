package de.fhswf.inf.oop.aufgabe7.uebung2;

public class Guest extends Person {

    public Guest(String name, int age) {
        super(name, age);
    }

    @Override
    public String getRoleDescription() {
        return "Gast der Hochschule";
    }


}
