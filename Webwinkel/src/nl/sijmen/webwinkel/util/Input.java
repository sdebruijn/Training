package nl.sijmen.webwinkel.util;

import java.util.Scanner;

public class Input {
	private static Scanner sc = new Scanner(System.in);

	public static int Integer() {
		while (true) {
			if (sc.hasNextInt()) {
				return sc.nextInt();
			} else {
				sc.next();
				System.out.println("Geen geldige invoer.");
			}
		}
	}

	public static int Integer(int upperLimit) {
		int output = 0;
		while (true) {
			if (sc.hasNextInt()) {
				output = sc.nextInt();
				if (output < upperLimit) {
					return output;
				} else {
					System.out.println("Bovengrens is " + upperLimit + " (exclusief).");
				}
			} else {
				sc.next();
				System.out.println("Geen geldige invoer. Moet integer zijn.");
			}
		}
	}

	public static int Integer(int lowerLimit, int upperLimit) {
		int output = 0;
		while (true) {
			if (sc.hasNextInt()) {
				output = sc.nextInt();
				if (lowerLimit <= output && output < upperLimit) {
					return output;
				} else {
					System.out.println("Ondergrens is " + lowerLimit + " (inclusief)." + "Bovengrens is " + upperLimit
							+ " (exclusief).");
				}
			} else {
				sc.next();
				System.out.println("Geen geldige invoer. Moet integer zijn.");
			}
		}
	}
	
	public static char Character(String arg) {
		    while (!sc.hasNext("["+arg+"]{1}")) {
		        System.out.println("Teken moet een van deze tekens zijn: '" + arg + "'");
		        sc.next();
		    }
		    return sc.next().charAt(0);
	}
	

}
