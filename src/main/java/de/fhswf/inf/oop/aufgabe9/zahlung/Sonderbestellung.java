package de.fhswf.inf.oop.aufgabe9.zahlung;

public class Sonderbestellung implements PartnerProgramm, PremiumKunde{

	@Override
	public double holeRabatt() {
		return PremiumKunde.super.holeRabatt();
	}
}
