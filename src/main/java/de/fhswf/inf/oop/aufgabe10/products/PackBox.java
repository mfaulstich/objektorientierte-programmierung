package de.fhswf.inf.oop.aufgabe10.products;

import java.util.ArrayList;
import java.util.List;

public class PackBox<T extends Product> {
	private List<T> products = new ArrayList<>();

	public void add(T product) {
		products.add(product);
	}

	public T getFirst(){
		return products.isEmpty() ? null :  products.get(0);
	}

}
