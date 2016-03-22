package nl.sijmen.webwinkel.products;

import java.security.InvalidParameterException;
import nl.sijmen.webwinkel.util.Test;

public abstract class Product {
	// Fields

	private String naam;
	private int prijs;
	private int voorraad;
	private int eenheid;

	// Constants
	public static final int gram = 1;
	public static final int kilo = 2;
	public static final int liter = 3;
	public static final int stuk = 4;
	public static final int pak = 5;

	// Constructors
	Product(String naam, int prijs, int voorraad, int eenheid) {
		this.naam = naam;

		Test.mustBePositive(prijs, "Prijs (" + prijs + ") moet positief zijn");
		this.prijs = prijs;

		Test.mustBePositive(voorraad, "Voorraad (" + voorraad + ") moet positief zijn");
		this.voorraad = voorraad;

		getEenheidNaam(eenheid); // test of eenheid bestaat.
		this.eenheid = eenheid;
	}

	Product(String naam, int prijs, int voorraad) {
		this(naam, prijs, voorraad, stuk);
	}

	// Abstract methods
	abstract public int getBTWPercentage();

	// Non-abstract methods
	public String getNaam() {
		return this.naam;
	}

	public int getPrijsPerEenheid() {
		return this.prijs;
	}

	public int getEenheid() {
		return this.eenheid;
	}

	public int getVoorraad() {
		return this.voorraad;
	}

	public String toString() {
		return "Productnaam: " + getNaam() + "  voorraad: " + getVoorraad() + " " + this.getEenheidNaam();
	}

	final public void setVoorraad(int voorraad) {
		if (voorraad < 0) {
			throw new InvalidParameterException("voorraad moet een positieve waarde hebben");
		}
		this.voorraad = voorraad;
	}

	public void haalUitVoorraad(int aantal) {
		if (this.voorraad < aantal) {
			throw new InvalidParameterException(
					"aantal (" + aantal + ") om uit de voorraad (" + this.voorraad + ") te halen is te groot.");
		}
		this.voorraad -= aantal;
	}

	/**
	 * Berekent de prijs.
	 * 
	 * @param hoeveelheid
	 *            aantal af te rekenen van dit product
	 * @param inclusief
	 *            true als prijs inclusief btw moet worden berekend
	 * @return
	 */
	public int getPrijs(int hoeveelheid, boolean inclusief) {
		int prijsPerEenheid;
		if (inclusief) {
			prijsPerEenheid = (int) (getPrijsPerEenheid() * (getBTWPercentage() + 100.0) / 100.0);
		} else {
			prijsPerEenheid = getPrijsPerEenheid();
		}
		return prijsPerEenheid * hoeveelheid;
	}

	public int getPrijs(int hoeveelheid) {
		return getPrijs(hoeveelheid, true);
	}

	public int getPrijs() {
		return getPrijsPerEenheid();
	}

	public String getEenheidNaam() {
		return getEenheidNaam(this.getEenheid());
	}

	static public String getEenheidNaam(int unit) {
		switch (unit) {
		case gram:
			return "gram";
		case kilo:
			return "kilo";
		case liter:
			return "liter";
		case stuk:
			return "stuk";
		case pak:
			return "pak";
		default:
			throw new InvalidParameterException("eenheid (" + unit + ") bestaat niet .");
		}
	}

}
