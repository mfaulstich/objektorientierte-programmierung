package de.fhswf.inf.oop.aufgabe2.uebung1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static final String DESCRIPTION = "Geben Sie einen Namen ein. Abbruch mit \"q\"";

    public static void main(String[] args) {

        /*
        Namensliste anlegen
         */
        List<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.console().reader());
        boolean canceled = false;
        System.out.println(DESCRIPTION);
        while (!canceled && scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "q":
                    canceled = true;
                    break;
                default:
                    names.add(input);
                    break;
            }
            if (!canceled) {
                System.out.println(DESCRIPTION);
            }
        }

        /*
        Ursprungs-Namensliste ausgeben
        */
        System.out.println("Inhalt Ursprungsliste:");
        for (String name: names){
            System.out.println(name);
        }
        System.out.println();
                
        /*
        Liste mit eindeutigen Namen erzeugen und ausgeben.
         */
        List<String> names2 = new ArrayList<>();
        for (String name: names){
            if (!names2.contains(name)){
                names2.add(name);
            }
        }
        System.out.println("Inhalt Uniqe-Liste:");
        Collections.sort(names2);
         for (String name: names2){
            System.out.println(name);
        }
        System.out.println();

        /*
        Sortierte Liste Collection eindeutiger Namen mit TreeSet erzeugen.
         */
        Set<String> wordSet = new TreeSet<>(names);
        System.out.println("Inhalt Set:");
         for (String name: wordSet){
            System.out.println(name);
        }
        System.out.println();

    }

}
