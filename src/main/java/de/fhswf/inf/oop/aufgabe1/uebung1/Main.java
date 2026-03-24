package de.fhswf.inf.oop.aufgabe1.uebung1;

import java.util.function.Function;

public class Main {

	private static final byte OUTPUT_MOTOR_RIGHT = 1;
	private static final byte OUTPUT_MOTOR_LEFT = 2;
	private static final byte OUTPUT_BREAK_ON = 4;
	private static final byte LIMIT_RIGHT = 16;
	private static final byte LIMIT_LEFT = 32;


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

	private static String toBinaryString(byte value) {
		String result = Integer.toBinaryString(Integer.valueOf(value));
		while (result.length() < 8) {
			result = "0" + result;
		}
		return result;
	};
}
