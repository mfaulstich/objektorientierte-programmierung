package de.fhswf.inf.oop.aufgabe10.products;

import java.util.Random;

public class Software implements Product {

	public String getLicenseKey() {
		return Long.valueOf(Math.round(new Random().nextFloat() * Math.pow(10,12))).toString();
	}

}
