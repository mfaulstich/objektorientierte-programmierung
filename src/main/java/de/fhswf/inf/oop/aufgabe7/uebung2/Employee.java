package de.fhswf.inf.oop.aufgabe7.uebung2;

public class Employee extends Person {
    public Employee(String name, int age) {
        super(name, age);
    }

    @Override
    public String getRoleDescription() {
        return "Mitarbeiter der Hochschule";
    }

}
