package de.fhswf.inf.oop.aufgabe2.uebung4;

public class Main {
	public static void main(String[] args) {
		double epsilon_Bier = 0.05;
		double epsilon_Wein = 0.12;
		double epsilon_Scotch = 0.46;
		double rho = 0.8; // Dichte von Alkohol;

		double m_Mann = 80; // Mann: 80kg
		double m_Frau = 60; // Frau: 60 kg
		double m_Kind = 40; // Kind 40kg

		double r_Mann = 0.7; // Verteilungsfaktor Mann
		double r_Frau = 0.6; // Verteilungsfaktor Frau
		double r_Kind = 0.8; // Verteilungsfaktor Kinder

		double _V = 500; // Volumen, 0,5l = 500m:

		String format = "%s, %.1fkg, trinkt %.2fml %-6s, Blutalkohol ~%.2f Promille\n";
		/*
		 * Mann
		 */
		// Bier
		String person_caption = "Mann";
		double m = m_Mann; // Masse der Person
		double r = r_Mann;

		String drink_caption = "Bier";
		double epsilon = epsilon_Bier;

		double A = _V * epsilon * rho; // Aufgenommene Masse des Alkohols in [g]
		double c = A / (m * r);
		System.out.printf(format, person_caption, m, _V,
				drink_caption, c);

		// Wein
		drink_caption = "Wein";
		epsilon = epsilon_Wein;

		A = _V * epsilon * rho; // Aufgenommene Masse des Alkohols in [g]
		c = A / (m * r);
		System.out.printf(format, person_caption, m, _V,
				drink_caption, c);

		// Scotch
		drink_caption = "Scotch";
		epsilon = epsilon_Scotch;

		A = _V * epsilon * rho; // Aufgenommene Masse des Alkohols in [g]
		c = A / (m * r);
		System.out.printf(format, person_caption, m, _V,
				drink_caption, c);

		/*
		 * Frau
		 */
		// Bier
		person_caption = "Frau";
		m = m_Frau; // Masse der Person
		r = r_Frau;

		drink_caption = "Bier";
		epsilon = epsilon_Bier;

		A = _V * epsilon * rho; // Aufgenommene Masse des Alkohols in [g]
		c = A / (m * r);
		System.out.printf(format, person_caption, m, _V,
				drink_caption, c);

		// Wein
		drink_caption = "Wein";
		epsilon = epsilon_Wein;

		A = _V * epsilon * rho; // Aufgenommene Masse des Alkohols in [g]
		c = A / (m * r);
		System.out.printf(format, person_caption, m, _V,
				drink_caption, c);

		// Scotch
		drink_caption = "Scotch";
		epsilon = epsilon_Scotch;

		A = _V * epsilon * rho; // Aufgenommene Masse des Alkohols in [g]
		c = A / (m * r);
		System.out.printf(format, person_caption, m, _V,
				drink_caption, c);

		/*
		 * Kind
		 */
		// Bier
		person_caption = "Kind";
		m = m_Kind; // Masse der Person
		r = r_Kind;

		drink_caption = "Bier";
		epsilon = epsilon_Bier;

		A = _V * epsilon * rho; // Aufgenommene Masse des Alkohols in [g]
		c = A / (m * r);
		System.out.printf(format, person_caption, m, _V,
				drink_caption, c);

		// Wein
		drink_caption = "Wein";
		epsilon = epsilon_Wein;

		A = _V * epsilon * rho; // Aufgenommene Masse des Alkohols in [g]
		c = A / (m * r);
		System.out.printf(format, person_caption, m, _V,
				drink_caption, c);

		// Scotch
		drink_caption = "Scotch";
		epsilon = epsilon_Scotch;

		A = _V * epsilon * rho; // Aufgenommene Masse des Alkohols in [g]
		c = A / (m * r);
		System.out.printf(format, person_caption, m, _V,
				drink_caption, c);
	}
}
