package de.fhswf.inf.oopold.aufgabe6.uebung1;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Student("Peter Pan", 19, "01234567"));
        System.out.println(new Student("Lisa Schlupke", 21, "12345678"));
        try {
            System.out.println(new Student("Lisa Schlupke", 21, "A2345678"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Student("Lisa Schlupke", 21, "1234567X"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
