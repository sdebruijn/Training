package nl.sijmen.inheritance.dierenwinkel;

public class DierenwinkelDemo {

	public static void main(String[] args) {
		Dier[] d = {
				new Dier("aap"),
				new Dier("konijn"),
				new Dier("schildpad") };
		DierenWinkel dw = new DierenWinkel(d);
		Dier[] dwVoorraad = dw.getVoorraad();
		
		Dier[] v = {
				new Vogel("mus"),
				new Vogel("zwaluw"),
				new Vogel("arend") };

		VogelSpeciaalzaak vs = new VogelSpeciaalzaak(v);
		Vogel[] vsVoorraad = vs.getVoorraad();
		
		System.out.print("Dieren op voorraad: ");
		for (Dier dier: dwVoorraad) {
			System.out.print(dier+ ", ");
		}
		
		System.out.println();
		System.out.print("Vogels op voorraad: ");
		for (Vogel vogel : vsVoorraad) {
			System.out.print(vogel + ", ");
		}
		
		
	}

}
