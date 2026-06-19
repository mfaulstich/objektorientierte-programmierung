package de.fhswf.inf.oop.aufgabe8.uebung1.uebung4b;

public class Main {

	public static void main(String[] args) {
		print("Hello World!\n");

	}

	public static void print(String text) {
		if (text == null ) {
			throw new IllegalArgumentException("Argument must not be null");
		}
		if (text.length() < 2) {
			throw new IllegalArgumentException(String.format("Expect at least 2 characters, has %d", text.length()));
		}
		System.out.println(text);
	}

	public static void print2(String text) {
		new StringLenAssertion(2).check(text);
		System.out.println(text);
	}

}
