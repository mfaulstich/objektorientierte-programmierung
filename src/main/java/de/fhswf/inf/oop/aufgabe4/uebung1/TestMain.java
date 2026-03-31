package de.fhswf.inf.oop.aufgabe4.uebung1;

public class TestMain {
    public static void main(String[] args) {
        String[] testCodes = {
                "ABC-01-2025",
                "AABC-01-2025",
                "ABCC-01-2025",
                "0BC-01-2025",
                "AB0-01-2025",
                "AB0-00-2025",
                "AB0-13-2025",
                "AB0-99-2025",
                "ABC-001-2025",
                "ABC-012-2025",
                "ABC-A0-2025",
                "ABC-0A-2025",
                "ABC-00-2025",
                "ABC-0A-2025",
                "ABC-01-9999",
                "ABC-12-9999",
                "ABC-01-1899",
        };
        for (String testCode : testCodes) {
            System.out.printf("%-15s: %-10s\n", testCode, Main.isValidCourseCode(testCode) ? "korrekt" : "falsch");
        }

    }
}
