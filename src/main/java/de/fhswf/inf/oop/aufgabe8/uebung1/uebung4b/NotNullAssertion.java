package de.fhswf.inf.oop.aufgabe8.uebung1.uebung4b;

public class NotNullAssertion {

	public void check(Object value) {
		if (value == null ) {
			throw new IllegalArgumentException("Argument must not be null");
		}
	}

}
