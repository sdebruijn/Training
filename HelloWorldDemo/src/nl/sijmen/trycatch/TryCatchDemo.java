package nl.sijmen.trycatch;
import java.util.Scanner;

public class TryCatchDemo {

	static String str;
	public static void main(String[] args) {
		System.out.println(str);
		// twoExceptionDemo();
		naamVanWeekdagDemo();
	}

	static void twoExceptionDemo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input number: ");
		String input = null;
		input = sc.next();
		try {
			int i = twoExceptions(input);
			System.out.println("Goede invoer!!! " + i);
		} catch (NumberFormatException e) {
			System.out.println("Oops, NumberFormatException...");
			System.out.println("Invoer was niet goed");
		} catch (NullPointerException e) {
			System.out.println("Oops, NullPointerException...");
		} finally {
			sc.close();
		}
	}

	static void naamVanWeekdagDemo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input dagnummer (1-7): ");
		String input = sc.next();

		try {
			int num = twoExceptions(input);
			String dag = naamVanWeekdag(num);
			System.out.println("De dag is " + dag);
		} catch (IllegalArgumentException e) {
			System.err.print("Error handling: ");
			System.err.println(e.getMessage());
		} catch (DatIsGeenWeekDag e) {
			System.out.println("Super fijn, nu moeten we deze exceptie vangen...");
			e.printStackTrace();
		} finally {
			sc.close();
		}
		sc.close();
		
		System.out.println("Pff.. nu ben ik klaar!");
	}

	static int twoExceptions(String getal) {
		return Integer.valueOf(getal.trim());
	}

	static String naamVanWeekdag(int dag) throws DatIsGeenWeekDag, NullPointerException {
		switch (dag) {
		case 1:
			return "maandag";
		case 2:
			return "dinsdag";
		case 3:
			return "woensdag";
		case 4:
			return "donderdag";
		case 5:
			return "vrijdag";
		case 6:
			return "zaterdag";
		case 7:
			return "zondag";
		default:
			throw new DatIsGeenWeekDag( dag + " is geen geldige dag van de week");
		}
	}
}

class DatIsGeenWeekDag extends Exception {
	public DatIsGeenWeekDag(String s) {super(s);}
	public DatIsGeenWeekDag() {super();}
	private static final long serialVersionUID = 1L;
}


