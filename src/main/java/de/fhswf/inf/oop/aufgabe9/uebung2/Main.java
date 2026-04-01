package de.fhswf.inf.oop.aufgabe9.uebung2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Lisa Penrose", 22, "45678910"));
        students.add(new Student("Karl Dall", 73, "12345678"));
        students.add(new Student("Marta Schluppke", 21, "34567891"));
        students.add(new Student("Peter Pan", 19, "01234567"));
        students.add(new Student("Milla Kapolke", 69, "23456789"));
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
