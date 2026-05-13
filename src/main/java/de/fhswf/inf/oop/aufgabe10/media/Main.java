package de.fhswf.inf.oop.aufgabe10.media;

import de.fhswf.inf.oop.aufgabe10.media.MediaBox;
import de.fhswf.inf.oop.aufgabe10.products.Book;
import de.fhswf.inf.oop.aufgabe10.products.PackBox;
import de.fhswf.inf.oop.aufgabe10.products.Product;
import de.fhswf.inf.oop.aufgabe10.products.Software;

public class Main {

	public static void main(String[] args) {
		System.out.println("Medien");
		MediaBox<String> stringMedia = new MediaBox<String>("Wert");
		MediaBox<Integer> integerMedia = new MediaBox<Integer>(3);
		String testString = stringMedia.getMedia();
		int testInt = integerMedia.getMedia();
		System.out.printf("%s: %d\n", testString, testInt);
		System.out.println();

	}

}
