package nl.sijmen.training;

import java.util.Scanner;

public class Exercise3 {

	public static void main (String[] args)
	{
		System.out.println("This program computes the length of the hypotenuse of a right triangle.\n"
				+ "Please enter the lengths of the sides of the triangle.\n\n"
				+ "Side 1: ");
		Scanner s = new Scanner(System.in);
		double a = s.nextDouble();
		
		System.out.println("Side 2: ");
		double b = s.nextDouble();
		
		System.out.println("Hypotenuse  : " + Math.sqrt(a*a+b*b) );
		
		s.close();
	}
}