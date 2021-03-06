package nl.sijmen.webwinkel.ui;

import java.util.ArrayList;
import java.util.Scanner;

import nl.sijmen.webwinkel.products.BeperktProduct;
import nl.sijmen.webwinkel.products.DefaultProduct;
import nl.sijmen.webwinkel.products.Product;
import nl.sijmen.webwinkel.util.Input;
import nl.sijmen.webwinkel.winkelwagen.Winkelwagen;

public class UserInterface {

	private static ArrayList<Product> voorraad = new ArrayList<Product>();
	private static Scanner sc = new Scanner(System.in);

	private static Winkelwagen wagen = new Winkelwagen();

	public static void main(String[] args) {
		// naam, prijs, voorraad, eenheid
		voorraad.add(new DefaultProduct("Boek OCA examen", 40, 1000, Product.stuk));
		voorraad.add(new DefaultProduct("Mock exam", 10, 400, Product.stuk));
		voorraad.add(new DefaultProduct("TV", 400, 15, Product.stuk));
		voorraad.add(new BeperktProduct("Melkpoeder", 15, 25, Product.pak, 2));

		boolean bContinue = true;

		while (bContinue) {
			char next = 'N';
			if (wagen.isEmpty()) {
				next = 'N';
			} else {
				next = nextCommand();
			}

			switch (next) {
			case 'C':
				veranderRegel();
				break;
			default:
				nieuwProduct();
				break;
			}

			// Print inhoud winkelwagen
			System.out.println(wagen);

			// Vraag afronoden of doorgaan?
			bContinue = inputContinue();
			if (bContinue) {
				clearConsole();
				System.out.println("Fijn dat u verder winkelt!");
			}
		}

	}

	private static void veranderRegel() {
		if (wagen.isEmpty()) {
			return;
		}
		// Voer in welk product je wilt veranderen
		System.out.println("Voer de regel in die u wilt veranderen: ");
		int regelNummer = Input.Integer(wagen.size());

		System.out.println("Wilt u ");
		System.out.println("\t [D] de regel verwijderen?");
		System.out.println("\t [C] de hoeveelheid wijzigen?");
		char actieType = Input.Character("CD");

		// Voer in wat je wilt doen:
		switch (actieType) {
		case 'C':
			System.out.println("Voer de nieuwe hoeveelheid in: ");
			int nieuweHoeveelheid = selectHoeveelheid();
			wagen.veranderBestelling(regelNummer, nieuweHoeveelheid);
			break;
		case 'D':
			break;
		default:
			throw new IllegalArgumentException();
		}
		// - Verander aantal (if newAantal == 0 -> delete)
		// - Verwijder
	}

	private static void nieuwProduct() {
		try {
			toonProducten();
			Product p = voorraad.get(selectProduct());
			wagen.bestel(p, selectHoeveelheid());
		} catch (IllegalArgumentException e) {
			System.err.println("Error bij het bestellen\n" + e.getMessage());
			// System.err.println(e.toString());
		}
	}

	private static char nextCommand() {
		char in = 'N';
		System.out.print(
				"Wat wilt u doen?\n" + "\tNieuw product [Other keys]\n" + "\tVerander product [C]\n" + "Input: ");
		in = sc.next().charAt(0);
		in = Character.toUpperCase(in);
		return in;
	}

	private static boolean inputContinue() {
		boolean continueShopping = false;
		while (true) {
			System.out.print("Wilt u verder winkelen?\n\tDoorgaan [J/Y]\n\tAfronden [N]\nInput: ");
			char in = sc.next().charAt(0);
			in = Character.toUpperCase(in);
			if (in == 'Y' || in == 'J') {
				continueShopping = true;
				break;
			}
			if (in == 'N') {
				continueShopping = false;
				System.out.println("Graag tot ziens. Voer uw rekeningnummber en PIN in...");
				break;
			}
			System.out.println("Uw invoer: " + in + ". Voor alstublieft 'Y' of 'N' in.");
		}
		return continueShopping;
	}

	private static int selectProduct() {
		int productNummer = -1;
		while (true) {
			System.out.print("Selecteer product: ");
			if (sc.hasNextInt()) {
				productNummer = sc.nextInt();

				if (0 < productNummer && productNummer <= voorraad.size()) {
					break;
				}
				System.out.println("Dit productnummer bestaat niet.");
			} else {
				sc.next();
				System.out.println("Geen geldige invoer.");
			}
		}
		return productNummer - 1; // since java is zero-based, but the output
									// format is 1-based.
	}

	private static int selectHoeveelheid() {
		int hoeveelheid = -1;
		while (true) {
			System.out.print("Geef de gewenste hoeveelheid: ");
			hoeveelheid = sc.nextInt();
			if (0 < hoeveelheid) {
				break;
			}
			System.out.println("De hoeveelheid moet positief zijn.");
		}
		return hoeveelheid;
	}

	private static void toonProducten() {
		String rule = "  ";
		int ruleLength = 76;
		for (int i = 0; i < ruleLength; i++) {
			rule += "-";
		}
		rule += "\n";

		String lijst = new String();
		lijst += String.format("  %-48s %-5s %21s\n", "Product", "Prijs", "Voorraad");
		lijst += rule;
		for (int j = 0; j < voorraad.size(); j++) {
			Product p = voorraad.get(j);
			lijst += String.format(" %2d) %-44s %5d E per %-10s %5d\n", j + 1, p.getNaam(), p.getPrijsPerEenheid(),
					p.getEenheidNaam(), p.getVoorraad());
		}
		lijst += rule;

		System.out.println(lijst);
	}

	private final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			System.out.println("\n\n\n\n\n\n");
		}
	}

}
