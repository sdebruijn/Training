package nl.sijmen.webwinkel.products;

import nl.sijmen.webwinkel.util.Test;

public class DefaultProduct extends Product {
	// Fields
	private String naam;
	private int prijs;
	private int eenheid;

	private int btwPercentage = 21;

	// Constructors
	public DefaultProduct(String naam, int prijs, int voorraad, int eenheid) {
		this.naam = naam;

		Test.mustBePositive(prijs, "Prijs (" + prijs + ") moet positief zijn");
		this.prijs = prijs;

		Test.mustBePositive(voorraad, "Voorraad (" + voorraad + ") moet positief zijn");
		this.voorraad = voorraad;

		getEenheidNaam(eenheid); // test of eenheid bestaat.
		this.eenheid = eenheid;
	}

	public DefaultProduct(String naam, int prijs, int voorraad) {
		this(naam, prijs, voorraad, stuk);
	}

	public int getBTWPercentage() {
		return this.btwPercentage;
	}

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
}
