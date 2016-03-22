package nl.sijmen.stringopdrachten;

public class Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Java OCA Examen";
		System.out.println(str);
		str = rot13(str);
		System.out.println(str);
		str = rot13(str);
		System.out.println(str);

	}

	public static String rot13(String input) {

		char[] ca = input.toCharArray();
		for (int i = 0; i < ca.length; ++i) {
			ca[i] = rot13(ca[i]);
		}
		return new String(ca);
	}

	private static char rot13(char c) {
		char base = 'a';
		if ('a' <= c && c <= 'z') {
			base = 'a';
		} else if ('A' <= c && c <= 'Z') {
			base = 'A';
		} else {
			return c;
		}
		return (char) ((c - base + 13) % 26 + base);
	}

	public static String[] splitDomeinName(String domainName) {

		// Een domeinnaam bestaat uit letters, cijfers, mintekens en punten.

		// Een punt of minteken mag alleen voorkomen tussen twee letters, twee
		// cijfers, of een letter en een cijfer

		// Na de laatste punt accepteer je alleen de Top Level Domains .com,
		// .nl, .org.
		if (!domainName.endsWith("com") && !domainName.endsWith("nl") && !domainName.endsWith("org")) {
			return null;
		}

		String[] ret = domainName.split(".");
		// Er komen tenminste twee punten voor in de domeinnaam
		if (ret.length <= 2) {
			return null;
		}
		return ret;
	}
	
	
	
}
