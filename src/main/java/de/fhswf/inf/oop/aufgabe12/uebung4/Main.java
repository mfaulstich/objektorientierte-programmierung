package de.fhswf.inf.oop.aufgabe12.uebung4;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File intFile = new File("integer.bin");
		try {
			IntegerFile.writeInt(42, intFile);
			System.out.println(intFile.getAbsolutePath() + " geschrieben");
			int result = IntegerFile.readInt(intFile);
			System.out.println(intFile.getAbsolutePath() + " gelesen");
			System.out.println("Ergebnis " + result);
		} catch (IOException e) {
			System.err.println("Fehler beim Bearbeiten von " + intFile.getAbsolutePath());
			e.printStackTrace();
		}
	}

}
