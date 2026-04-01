package de.fhswf.inf.oop.aufgabe7.uebung1;

public class Rectangle extends Shape {
    private double width;
    private double height;

    /**
     * Initialisierungskonstruktor.
     * 
     * @param height Höhe des Rechtecks. Muss ein Wert >= 0.0 sein.
     * @param width  Breite des Rechtecks. Muss ein Wert >= 0.0 sein.
     */
    public Rectangle(double height, double width) {
        if (height < 0.0) {
            throw new IllegalArgumentException(
                    String.format("Erwarte positiven Wert für die Höhe, ist aber %.2f", height));
        }
        if (width < 0.0) {
            throw new IllegalArgumentException(
                    String.format("Erwarte positiven Wert für die Breite, ist aber %.2f", width));
        }
        this.height = height;
        this.width = width;

    }

    /**
     * @return Fläche des Rechtecks.
     */
    @Override
    public double area() {
        return height * width;
    }

    /**
     * @return Beschreibung der Geometrie und der Kenngrößen
     */
    @Override
    public String toString() {
        return String.format("Rechteck, h=%.2f, w=%.2f", height, width);
    }

}
