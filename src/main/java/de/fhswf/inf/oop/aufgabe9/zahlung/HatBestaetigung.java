package de.fhswf.inf.oop.aufgabe9.zahlung;

public interface HatBestaetigung {
    default void sendeBestaetigung() {
        System.out.println("Hier ist die Bestätigung!");
    }
}
