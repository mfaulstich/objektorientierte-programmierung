package de.fhswf.inf.oop.aufgabe10.products;

import de.fhswf.inf.oop.aufgabe10.media.MediaBox;
import de.fhswf.inf.oop.aufgabe10.products.Book;
import de.fhswf.inf.oop.aufgabe10.products.PackBox;
import de.fhswf.inf.oop.aufgabe10.products.Product;
import de.fhswf.inf.oop.aufgabe10.products.Software;

public class Main {

	public static void main(String[] args) {

		System.out.println("Bücher");
		PackBox<Book> bookBox = new PackBox<>();
		bookBox.add(new Book());
		bookBox.add(new Book());

		Product p = bookBox.getFirst();
		System.out.printf("ISBN erstes Buch: %s\n", bookBox.getFirst().getISBN());

		System.out.println("Software");
		PackBox<Software> softwareBook = new PackBox<>();
		softwareBook.add(new Software());
		softwareBook.add(new Software());
		System.out.printf("Lizenz erste Software: %s\n", softwareBook.getFirst().getLicenseKey());
	}

}
