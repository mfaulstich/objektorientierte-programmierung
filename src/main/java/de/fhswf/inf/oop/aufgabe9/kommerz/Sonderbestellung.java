package de.fhswf.inf.oop.aufgabe9.kommerz;

public class Sonderbestellung implements PartnerProgramm, PremiumKunde{

	@Override
	public double holeRabatt() {
		return PremiumKunde.super.holeRabatt();
	}
}
