package de.fhswf.inf.oop.aufgabe10.products;

import java.util.Random;

public class Book implements Product {

	public String getISBN() {
		return Long.valueOf(Math.round(new Random().nextFloat() * Math.pow(10,12))).toString();
	}

}
