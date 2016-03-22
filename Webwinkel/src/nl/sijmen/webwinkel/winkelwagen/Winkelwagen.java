package nl.sijmen.webwinkel.winkelwagen;

import java.util.ArrayList;
import java.util.ListIterator;

import nl.sijmen.webwinkel.products.Product;

public final class Winkelwagen {
	// Fields
	private ArrayList<ProductBestelling> bestellingen;
	private int totaalPrijs;
	private int totaalPrijsExBTW;

	// Constructor
	public Winkelwagen() {
		bestellingen = new ArrayList<ProductBestelling>();
		assert (totaalPrijs == 0);
		assert (totaalPrijsExBTW == 0);
	}

	// Methods
	public int getTotaalPrijs() {
		return totaalPrijs;
	}

	public int getTotaalPrijsExBTW() {
		return totaalPrijsExBTW;
	}

	public void bestel(Product p, int hoeveelheid) {
		if (hoeveelheid <= 0) {
			throw new IllegalArgumentException("Hoeveelheid moet strikt positief zijn");
		}
		
		System.out.println("Bezig om " + hoeveelheid + " " + p.getEenheidNaam() + " " + p.getNaam() + " te bestellen...");
		
		boolean modified = false;
		ListIterator<ProductBestelling> itr = bestellingen.listIterator();
		while(itr.hasNext()){
		    ProductBestelling pb = (ProductBestelling) itr.next();
		    String pbName = pb.getProductNaam();
		    if (pbName.equals(p.getNaam()) ) {
		    	// replace / modify
		    	modified = true;
		    	p.haalUitVoorraad(hoeveelheid);
		    	
		    	pb.setHoeveelheid( pb.getHoeveelheid() + hoeveelheid);
		    	itr.set(pb);
		    }
		}
		
		if (!modified) {
			p.haalUitVoorraad(hoeveelheid);
			ProductBestelling order = new ProductBestelling(p, hoeveelheid);
			bestellingen.add(order);	
		}
		
		totaalPrijsExBTW += p.getPrijs(hoeveelheid, false);
		totaalPrijs += p.getPrijs(hoeveelheid, true);
	}

	// TODO: Voeg methode deleteRegel(int regelNummer) toe
	

	public String toString() {
		String bon = new String();
		bon += String.format("%-40s %-10s %-20s\n", "Product", "Aantal", "Prijs (ex BTW)");
		bon += "------------------------------------------------------------------\n";
		for (ProductBestelling pb : bestellingen) {
			bon += pb.toString();
		}
		bon += "------------------------------------------------------------------\n";
		final String formatTwo = "%-46s %10d\n";
		bon += String.format(formatTwo, "Totaal Ex BTW", totaalPrijsExBTW);
		bon += String.format(formatTwo, "BTW", totaalPrijs - totaalPrijsExBTW);
		bon += String.format(formatTwo, "Totaal", totaalPrijs);
		return bon;
	}
	
	

	final private class ProductBestelling {
		// Fields
		private Product product;
		private int hoeveelheid;

		// Constructors
		public ProductBestelling(Product product, int hoeveelheid) {
			this.product = product;
			this.hoeveelheid = hoeveelheid;
		}

		@SuppressWarnings("unused")
		public ProductBestelling(Product product) {
			this(product, 1);
		}
		
		@Override
		public String toString() {
			//return "out: " + this.product.getNaam() + " " + this.getHoeveelheid() + " "
			//		+ this.product.getPrijs(this.getHoeveelheid(), false);
			return String.format("%-40s %6d %9d\n", this.product.getNaam(), this.getHoeveelheid(),
			 this.product.getPrijs(this.getHoeveelheid(), false));
		}

		// Methods
		@SuppressWarnings("unused")
		public void setHoeveelheid(int hoeveelheid) {
			if (hoeveelheid > 0) {
				this.hoeveelheid = hoeveelheid;
			} else if (hoeveelheid == 0) {
				// TODO: DELETE ENTRY?
				this.hoeveelheid = hoeveelheid;
			} else {
				throw new IllegalArgumentException("Hoeveelheid moet positief zijn.");
			}
		}

		public int getHoeveelheid() {
			return this.hoeveelheid;
		}

		public int getPrijs(boolean inclusief) {
			return this.product.getPrijs(hoeveelheid, inclusief);
		}

		@SuppressWarnings("unused")
		public int getPrijs() {
			return getPrijs(true);
		}



		@SuppressWarnings("unused")
		public String getProductNaam() {
			return this.product.getNaam();
		}

	}

}
