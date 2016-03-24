package nl.sijmen.inheritance;

public class PhoneDemo {

	public PhoneDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MobilePhone[] phones = {
				new Samsung(),
				new LG(),
				new Apple()
		};
		
		for (MobilePhone p : phones) {
			System.out.println("Phone with "+ p.getOS());
			if (p instanceof USBCharger) {
				((USBCharger) p).charge();
			}
			if (p instanceof Apple) {
				((Apple) p).specialCharge();
			}
		}
	}
}

interface USBCharger {
	public void charge();
}

abstract class MobilePhone {
	public abstract String getOS();
}

class Samsung extends MobilePhone implements USBCharger {
	@Override
	public void charge() {
		System.out.println("Charge Samsung over USB!");
	}

	@Override
	public String getOS() {
		return "Android";
	}
}

class LG extends MobilePhone implements USBCharger {
	@Override
	public void charge() {
		System.out.println("Charge LG over USB!");
	}

	@Override
	public String getOS() {
		return "Android";
	}
}

class Apple extends MobilePhone {
	public void specialCharge() {
		System.out.println("I'm Apple! I'm special! Charge me with something other than USB!");
	}

	@Override
	public String getOS() {
		return "iOS";
	}
}
