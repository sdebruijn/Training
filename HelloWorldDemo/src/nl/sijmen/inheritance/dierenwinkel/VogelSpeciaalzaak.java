package nl.sijmen.inheritance.dierenwinkel;

import java.security.InvalidParameterException;

public class VogelSpeciaalzaak extends DierenWinkel {

	private Vogel[] dieren;
	public VogelSpeciaalzaak(Vogel[] vogels) {
		this.dieren = vogels;
	}
	
	public VogelSpeciaalzaak(Dier[] dieren) {
		this.dieren = new Vogel[dieren.length];
		for (int i =0; i< dieren.length; i++ ) {
			if (!(dieren[i] instanceof Vogel)) {
				throw new InvalidParameterException("Moet een vogel zijn");
			}
			this.dieren[i] = (Vogel) dieren[i];
		}
	}
	
	public  VogelSpeciaalzaak() {
	}
	
	@Override
	public Vogel[] getVoorraad() {
		return this.dieren;
	}

}
