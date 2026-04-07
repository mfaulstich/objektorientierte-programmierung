package de.fhswf.inf.oopold.aufgabe7.uebung1;

public class Circle extends Shape {
    private double radius;

    /**
     * Initialisierungskonstruktor.
     * 
     * @param radius Radius des Kreises. Muss ein Wert >= 0.0 sein.
     */
    public Circle(double radius) {
        if (radius < 0.0) {
            throw new IllegalArgumentException(
                    String.format("Erwarte positiven Wert für den Radius, ist aber %.2f", radius));
        }
        this.radius = radius;

    }

    /**
     * @return Fläche des Kreises.
     */
    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    /**
     * @return Beschreibung der Geometrie und der Kenngrößen
     */
    @Override
    public String toString() {
        return String.format("Kreis, r=%.2f", radius);
    }
}
