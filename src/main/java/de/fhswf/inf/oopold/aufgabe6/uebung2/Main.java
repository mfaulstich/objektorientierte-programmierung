package de.fhswf.inf.oopold.aufgabe6.uebung2;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Animal(),
                new Cat(),
                new Dog(),
                new StBernhardDog()
        };
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }
    }
}
