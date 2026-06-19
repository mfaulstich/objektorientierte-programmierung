package de.fhswf.inf.oop.aufgabe8.uebung1.uebung4b;

public class StringLenAssertion {

    private NotNullAssertion notNullAssertion = new NotNullAssertion();
	private int minLength;

	public StringLenAssertion(int minLength) {
		this.minLength = minLength;
	}

	public void check(String value) {
		notNullAssertion.check(value);
		if (value.length() < minLength) {
			throw new IllegalArgumentException(String.format("Expect at least %d characters, has %d", minLength, value.length()));
		}

	}
}
