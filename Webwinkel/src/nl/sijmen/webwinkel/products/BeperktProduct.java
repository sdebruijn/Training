package nl.sijmen.webwinkel.products;

import java.security.InvalidParameterException;

import nl.sijmen.webwinkel.util.Test;

public class BeperktProduct extends DefaultProduct {

	private int maxHoeveelheid;

	public BeperktProduct(String naam, int prijs, int voorraad, int eenheid, int maxHoeveelheid) {
		super(naam, prijs, voorraad, eenheid);

		Test.mustBeStrictlyPositive(maxHoeveelheid,
				"maxHoeveelheid (" + maxHoeveelheid + ") moet strikt positief zijn");
		this.maxHoeveelheid = maxHoeveelheid;
	}

	public BeperktProduct(String naam, int prijs, int voorraad, int eenheid) {
		super(naam, prijs, voorraad, eenheid);
	}

	public BeperktProduct(String naam, int prijs, int voorraad) {
		super(naam, prijs, voorraad);
	}

	@Override
	public void haalUitVoorraad(int aantal) {
		if (this.maxHoeveelheid < aantal) {
			throw new InvalidParameterException("Gewenste aantal (" + aantal
					+ ") om in een keer uit de voorraad te halen is groter dan de maximale toegestane hoeveelheid ("
					+ this.maxHoeveelheid + ").");
		}
		super.haalUitVoorraad(aantal);
	}

}
