package de.fhswf.inf.oop.aufgabe9.kommerz;

public abstract class Transaction {
    private final String id;
    private double betrag;

    public Transaction(String id, double betrag) {
    	if (!validiereId(id)) {
    		throw new IllegalArgumentException("Ungültige Id");
    	}
        this.id = id;
        this.betrag = betrag;
    }

    // Package-sichtbare Methode
    abstract void ausfuehren();

    public double getBetrag(){
        return betrag;
        
    }
    
    private static boolean validiereId(String id) {
    	return id != null && !id.isBlank();
    }
}
