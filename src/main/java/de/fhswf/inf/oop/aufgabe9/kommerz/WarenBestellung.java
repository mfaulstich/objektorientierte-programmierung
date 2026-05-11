package de.fhswf.inf.oop.aufgabe9.kommerz;

public class WarenBestellung extends Transaction implements Versandfaehig, HatBestaetigung {
	public WarenBestellung(String id, double betrag) {
		super(id, betrag);
	}
    @Override
    public void ausfuehren() {
        System.out.printf("Führe %s.ausfuehren() aus mit einem Betrag von %.2f\n", getClass().getSimpleName(), getBetrag());
    }


	public void verpacken() {
		System.out.printf("%s meldet: \"Verpackt\"\n", getClass().getSimpleName());
		sendeBestaetigung();
	}

}
