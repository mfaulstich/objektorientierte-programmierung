package de.fhswf.inf.oop.aufgabe2.uebung1;

public class Main {
    public static void main(String[] args) {
    	int a=-1, b= 8, c= 3;
    	System.out.println(~a == (a ^ a)); // Ausgabe: true
    	System.out.println(~~a == a); // Ausgabe: true
    	//System.out.println(!a < 0 ? a : -a); // Ausgabe: 1
    	System.out.println(a >>> 1 == Integer.MAX_VALUE); // Ausgabe: false
    	System.out.println((b & c) % (b | c)); // Ausgabe: 0
    	System.out.println((b | c) % (b & c)); // Ausgabe: 0

    }
}
