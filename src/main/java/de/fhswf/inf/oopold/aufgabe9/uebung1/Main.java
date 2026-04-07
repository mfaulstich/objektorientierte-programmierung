package de.fhswf.inf.oopold.aufgabe9.uebung1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Printable> printables = new ArrayList<>();
        printables.add(new Student("Peter Pan", 19, "01234567"));
        printables.add(new Student("Karl Dall", 73, "12345678"));
        printables.add(new Student("Milla Kapolke", 69, "23456789"));
        printables.add(new Student("Marta Schluppke", 21, "34567891"));
        printables.add(new Student("Lisa Penrose", 22, "45678910"));
        printables.add(new Course("ABC-01-2020", "Testkurs 1", 10));
        printables.add(new Course("CDE-01-2021", "Testkurs 2", 20));
        printables.add(new Course("FGH-01-2022", "Testkurs 3", 30));
        printables.add(new Course("IJK-01-2023", "Testkurs 4", 40));
        printables.add(new Course("LMO-01-2020", "Testkurs 5", 50));
        for(Printable printable:printables){
            printable.print();;
        }
    }
}
