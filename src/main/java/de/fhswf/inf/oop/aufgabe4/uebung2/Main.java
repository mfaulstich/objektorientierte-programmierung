package de.fhswf.inf.oop.aufgabe4.uebung2;

public class Main {
    public static void main(String[] args) {
        double dy = 4;
        double dx = 5;
        System.out.printf("%3.2f + %3.2f = %3.2f\n", dx, dy, add(dx, dy));
        System.out.printf("%3.2f - %3.2f = %3.2f\n", dx, dy, subtract(dx, dy));
        System.out.printf("%3.2f * %3.2f = %3.2f\n", dx, dy, multiply(dx, dy));
        System.out.printf("%3.2f / %3.2f = %3.2f\n", dx, dy, divide(dx, dy));
        dy = 0.0;
        try {
            System.out.printf("%3.2f / %3.2f = %3.2f\n", dx, dy, divide(dx, dy));
        } catch (IllegalArgumentException e) {
            System.out.printf("%3.2f / %3.2f = %s\n", dx, dy, e.getMessage());
        }

        int iy = 4;
        int ix = 5;
        System.out.printf("%3d + %3d = %3.2f\n", ix, iy, add(ix, iy));
        System.out.printf("%3d - %3d = %3.2f\n", ix, iy, subtract(ix, iy));
        System.out.printf("%3d * %3d = %3.2f\n", ix, iy, multiply(ix, iy));
        System.out.printf("%3d / %3d = %3.2f\n", ix, iy, divide(ix, iy));
        iy= 0;
        try {
            System.out.printf("%3d / %3d = %3.2f\n", ix, iy, divide(ix, iy));
        } catch (IllegalArgumentException e) {
            System.out.printf("%3d / %3d = %s\n", ix, iy, e.getMessage());
        }
    }

    /**
     * Addition zweier Operanden
     * 
     * @param x Operand 1
     * @param y Operand 2
     * @return x + y
     */
    public static double add(double x, double y) {
        return x + y;
    }

    /**
     * Subtraktion zweier Operanden
     * 
     * @param x Operand 1
     * @param y Operand 2
     * @return x - y
     */
    public static double subtract(double x, double y) {
        return x - y;
    }

    /**
     * Multiplikation zweier Operanden
     * 
     * @param x Operand 1
     * @param y Operand 2
     * @return x * y
     */
    public static double multiply(double x, double y) {
        return x * y;
    }

    /**
     * Division zweier Operanden
     * 
     * @param x Operand 1
     * @param y Operand 2
     * @return x / y
     */
    public static double divide(double x, double y) {
        if (Math.abs(y) < 1E-12) {
            throw new IllegalArgumentException("Division durch 0!");
        }
        return x / y;
    }

    /**
     * Addition zweier Operanden
     * 
     * @param x Operand 1
     * @param y Operand 2
     * @return x + y
     */
    public static double add(int x, int y) {
        return x + y;
    }

    /**
     * Subtraktion zweier Operanden
     * 
     * @param x Operand 1
     * @param y Operand 2
     * @return x - y
     */
    public static double subtract(int x, int y) {
        return x - y;
    }

    /**
     * Multiplikation zweier Operanden
     * 
     * @param x Operand 1
     * @param y Operand 2
     * @return x * y
     */
    public static double mutliply(int x, int y) {
        return x * y;
    }

    /**
     * Division zweier Operanden
     * 
     * @param x Operand 1
     * @param y Operand 2
     * @return x / y
     */
    public static double divide(int x, int y) {
        if (Math.abs(y) == 0) {
            throw new IllegalArgumentException("Division durch 0!");
        }
        return x / y;
    }
}
