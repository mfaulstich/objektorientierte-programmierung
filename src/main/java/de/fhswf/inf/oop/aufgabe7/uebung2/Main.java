package de.fhswf.inf.oop.aufgabe7.uebung2;

public class Main {
    public static void main(String[] args) {
        String headerFormat = "%-40s %s\n";
        System.out.printf(headerFormat, "Person", "Rolle");
        Person person = new Student("Peter Pan", 19, "01234567");
        System.out.printf(headerFormat, person, person.getRoleDescription());
        person = new Employee("Karl Dall", 75);
        System.out.printf(headerFormat, person, person.getRoleDescription());
        person = new Employee("Milla Kapolke", 69);
        System.out.printf(headerFormat, person, person.getRoleDescription());

    }
}
