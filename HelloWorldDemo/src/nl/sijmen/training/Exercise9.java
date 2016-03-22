package nl.sijmen.training;

import java.util.Scanner;

public class Exercise9 {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Only enter numbers in the range of 1 through 10");
		
		int x = 10;
		while(x-->0)
		{
			int i = readInt();
			System.out.println("You entered an integer! It was " + i);
			System.out.println(" ");
		}
	}
	
	public static int readInt() {
		int num = 0;
		System.out.print("Input: ");
		while (s.hasNext()) {
			if (s.hasNextInt()) {
				num = s.nextInt();
				if (0 < num && num <= 10)
					break;
			}

			System.out.println("Not an integer between 1 and 10. Try again...");
			System.out.println("Input: ");
			s.nextLine(); // Just discard this, not interested...
		}
		return num;
	}
}