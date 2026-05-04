package de.fhswf.inf.oop.aufgabe7.uebung2;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        /*
         * user.id = "123";
         * user.username = "Karl Dall";
         * user.password = "geheim";
         */
        user.setId("123");
        user.setUsername("Karl Dall");
        user.setPassword("geheim");
        System.out.println(user);
    }
}
