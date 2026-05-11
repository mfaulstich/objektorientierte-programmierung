package de.fhswf.inf.oop.aufgabe9.kommerz;

public interface HatBestaetigung {
    default void sendeBestaetigung() {
        System.out.println("Hier ist die Bestätigung!");
    }
}
