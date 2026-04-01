package de.fhswf.inf.oop.aufgabe7.uebung1;

public class Main {
    public static void main(String[] args) {
        String headerFormat = "%-30s %s\n";
        String rowFormat = "%-30s %5.2f\n";
        System.out.printf(headerFormat, "Form", "Fläche");
        Shape s = new Circle(5.0);
        System.out.printf(rowFormat, s.toString(), s.area());
        s = new Rectangle(4.0, 5.0);
        System.out.printf(rowFormat, s.toString(), s.area());
        try {
            new Circle(-1.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new Rectangle(-1.0, 2.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new Rectangle(1.0, -2.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
