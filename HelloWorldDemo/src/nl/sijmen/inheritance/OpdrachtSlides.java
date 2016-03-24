package nl.sijmen.inheritance;

public class OpdrachtSlides {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Groet[] list = {
			new Groet(),
			new NetteGroet(true),
			new NetteGroet(false)
		};
		
		for (Groet groet : list) {
			System.out.println(groet.get());
		}
	}

}

class Groet {
	public String get() {
		return "Hallo";
	}
}

class NetteGroet extends Groet {
	private boolean geslacht; // true for men

	public String get() {
		return super.get() + (geslacht ? "meneer" : "mevrouw");
	}

	public NetteGroet(boolean geslacht) {
		this.geslacht = geslacht;
	}
}