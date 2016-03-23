package nl.sijmen.webwinkel.products;

import java.security.InvalidParameterException;

public abstract class Product {
	protected int voorraad;

	// Constants
	public static final int gram = 1;
	public static final int kilo = 2;
	public static final int liter = 3;
	public static final int stuk = 4;
	public static final int pak = 5;

	// Constructors
	Product(String naam, int prijs, int voorraad, int eenheid) {
	}

	Product(String naam, int prijs, int voorraad) {
	}

	Product() {
	}

	// Abstract methods
	public abstract int getBTWPercentage();
	public abstract String getNaam();
	public abstract int getPrijsPerEenheid();
	public abstract int getEenheid();
	public abstract int getVoorraad();

	// Non-abstract methods
	public String toString() {
		return "Productnaam: " + getNaam() + "  voorraad: " + getVoorraad() + " " + this.getEenheidNaam();
	}

	public final void setVoorraad(int voorraad) {
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

	/**
	 * Geeft de eenheid van ofwel het product, ofwel die van de corresponderende
	 * integer.
	 * 
	 * @return String naam van eenheid
	 */
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

} // end of class Product
