package de.fhswf.inf.oop.aufgabe2.uebung3;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello World!\n");
        
        double dValue1 = 1.0;
        System.out.printf("%f\n", dValue1);
        System.out.printf("%.2f\n", dValue1);
        
        double dValue2 = -100.0;
        double dValue3 = 100000.0;
        
        String format = "%10.2f\n";
        System.out.printf(format, dValue1);
        System.out.printf(format, dValue2);
        System.out.printf(format, dValue3);
        
        String caption1 = "Temperatur / °C";
        String caption2 = "Druck / bar";
        String caption3 = "Verbrauch / kwh";
        
        System.out.println();
        
        format = "%-15s : %10.2f\n";
        System.out.printf(format,caption1, dValue1);
        System.out.printf(format,caption2, dValue2);
        System.out.printf(format,caption3, dValue3);
        
    }
}
