package nl.sijmen.inheritance.dierenwinkel;

public class DierenWinkel {
	Dier[] voorraad;
	
	public Dier[] getVoorraad() {
		return this.voorraad;
		
	}
	
	public DierenWinkel() {}
	public DierenWinkel(Dier[] dieren) {
		voorraad = dieren;
	}

}
