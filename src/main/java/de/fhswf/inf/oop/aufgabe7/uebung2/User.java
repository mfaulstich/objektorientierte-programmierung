package de.fhswf.inf.oop.aufgabe7.uebung2;

import static java.lang.Math.unsignedMultiplyHigh;

public class User {
    private String id;
    private String username;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    String.format("Erwarte gültige Zeichenkette, ist aber \"%s\"", String.valueOf(id)));
        }
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException(
                    String.format("Erwarte gültige Zeichenkette, ist aber \"%s\"", String.valueOf(username)));
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException(
                    String.format("Erwarte gültige Zeichenkette, ist aber \"%s\"", String.valueOf(password)));
        }
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%s: Id=%s, Passwort=%s", username, id, password);
    }

}
