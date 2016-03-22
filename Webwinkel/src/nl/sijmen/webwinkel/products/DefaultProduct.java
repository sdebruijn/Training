package nl.sijmen.webwinkel.products;

public final class DefaultProduct extends Product {
	// Fields
	final static private int BTWPercentage = 26;
	
	// Constructors
	public DefaultProduct(String naam, int prijs, int voorraad, int eenheid) {
		super(naam, prijs, voorraad, eenheid);
	}

	public DefaultProduct(String naam, int prijs, int voorraad) {
		super(naam, prijs, voorraad);
	}

	// Methods
	@Override
	public int getBTWPercentage() {
		return BTWPercentage;
	}
	
	@Override
	public String getNaam() {
		return super.getNaam() + " (Default product)";
	}
	
}
