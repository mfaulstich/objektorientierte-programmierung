package de.fhswf.inf.oop.aufgabe10.wildcards;

import java.util.List;

public class Util {
    public static <T extends Mitarbeiter> void transfer(List<? extends T> src, List<? super T> dest) {
        for (T element : src) {
            dest.add(element);
        }
    }
}