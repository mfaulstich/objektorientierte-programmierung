package de.fhswf.inf.oop.aufgabe12.uebung1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			File stringFile = new File("stringfile.txt");
			System.out.println(stringFile.getAbsolutePath());

			FileWriter fileWriter = new FileWriter(stringFile);
			fileWriter.write("Hallo Welt!");
			fileWriter.close();

			char[] buffer = new char[1024];
			FileReader fileReader = new FileReader(stringFile);
			int charReaded = fileReader.read(buffer);
			fileReader.close();
			if (charReaded < 0) {
				throw new IllegalStateException("Nichts aus der Datei gelesen.");
			}

			String content = new String(buffer, 0, charReaded);
			System.out.printf("%d Zeichen gelesen: %s\n", charReaded, content);

		} catch (Exception e) {
			System.err.println("Fehler bei der Dateibearbeitung: " + e.getMessage());
		}
	}

}
