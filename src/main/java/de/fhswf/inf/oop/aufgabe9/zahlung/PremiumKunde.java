package de.fhswf.inf.oop.aufgabe9.zahlung;

public interface PremiumKunde {

	default double holeRabatt() {
		return 3.0;
	}
}