package de.fhswf.inf.oop.aufgabe12.uebung2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        File stringFile = new File("/workspaces/objektorientierte-programmierung/src/main/java/de/fhswf/inf/oop/aufgabe12/uebung2/loreipsum.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(stringFile))){
            
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            System.err.println("Fehler bei der Dateibearbeitung: " + e.getMessage());
        }
    }
}
