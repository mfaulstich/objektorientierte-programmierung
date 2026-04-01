package de.fhswf.inf.oop.aufgabe7.uebung2;

public abstract class Person {
    private String name;
    private int age;

    /**
     * Initalisierungskonstruktor.
     * 
     * @param name Delegiert an {@link #setName(String)}.
     * @param age  Delegiert an {@link #setAge(int)}.
     * @throws IllegalArgumenmtException bei ungültigem Parameter.
     */
    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    /**
     * @return Gibt den Namen der Person zurück.
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen
     * 
     * @param name Name der Person. Darf nicht null oder leer sein und nicht
     *             ausschließlich aus Whitespace-Zeichen bestehen.
     * @throws IllegalArgumentException bei ungültigem Wert für den Namen.
     */
    public void setName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException(String.format("Erwarte gültigen Namen, ist \"%s\"", name));
        }
        this.name = name;
    }

    /**
     * @return Gibt das Alter der Person zurück.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setzt das Alter der Person
     * 
     * @param age Alter der Person. Darf micht negativ sein.
     * @throws IllegalArgumentException bei ungültigem Wert für das Alter.
     */
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(String.format("Erwarte positives Alter, ist \"%s\"", age));
        }
        this.age = age;

    }

    /**
     * Gibt die Attribute der Person als String formatiert zurück.
     * 
     * @see java.lang.Object.toString()
     */
    @Override
    public String toString() {
        return String.format("%s, %d Jahre", name, age);
    }

    /**
     * Gibt eine Beschreibung der Rolle zurück.
     * @return Beschreibung der Rolle.
     */
    public abstract String getRoleDescription();
}
