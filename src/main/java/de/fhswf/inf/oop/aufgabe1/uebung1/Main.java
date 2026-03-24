package de.fhswf.inf.oop.aufgabe1.uebung1;

import java.util.function.Function;

/**
 * Aufgabe 1 Übung 1: Umgang mit Bitmasken
 */
public class Main {

	private static final byte OUTPUT_MOTOR_RIGHT = 1;
	private static final byte OUTPUT_MOTOR_LEFT = 2;
	private static final byte OUTPUT_BREAK_ON = 4;
	private static final byte LIMIT_RIGHT = 16;
	private static final byte LIMIT_LEFT = 32;

	/**
	 * Startmethode der Anwendung
	 * 
	 * @param args Übergebene Argumente beim Starten auf einer Konsole. Nicht
	 *             verwendet.
	 */
	public static void main(String[] args) {
		// Setze Ausgangssituation
		byte value = LIMIT_RIGHT;
		System.out.println(toBinaryString(value));
		value |= OUTPUT_MOTOR_RIGHT;
		System.out.println(toBinaryString(value));
		value &= ~OUTPUT_MOTOR_RIGHT;
		System.out.println(toBinaryString(value));
		System.out.printf("Limit right: %s\n", (value &= LIMIT_RIGHT) != 0 ? "On" : "Off");
	}

	/**
	 * Binärwert eines byte als String
	 * 
	 * @param value Wert, dessen Bitmuster zurückgegeben wird.
	 * @return 8 Bits von value als String: "00000000". Führenden "0"-Werte auf 8
	 *         Binärstellen aufgefüllt.
	 */
	public static String toBinaryString(byte value) {
		String result = Integer.toBinaryString(Integer.valueOf(value));
		while (result.length() < 8) {
			result = "0" + result;
		}
		return result;
	};
}
