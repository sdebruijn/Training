package nl.sijmen.firstprogram;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Enter an article: ");
		String article = s.nextLine();
		System.out.println("Enter a noun: ");
		String noun = s.nextLine();
		System.out.println("Enter a verb: ");
		String verb = s.nextLine();
		
		String result = article;
		result += " " + verb;
		result += " " + noun + ".";
		
		System.out.println(result);
	}

}