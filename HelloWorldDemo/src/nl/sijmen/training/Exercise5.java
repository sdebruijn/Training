package nl.sijmen.training;

import java.util.Scanner;

public class Exercise5 {

	public static void main (String[] args)
	{
		System.out.println("Enter two integers.");
		Scanner s = new Scanner(System.in);
		
		System.out.println("x: ");
		int x = s.nextInt();
		
		System.out.println("y: ");
		int y = s.nextInt();
		
		s.close();
		
		
		if (x / y == 5) 	x = 100;
		System.out.println("Test divisability by 5.");
		System.out.println("x: " + x);
		
		
		if (x*y == 5) 		x = 1;
		System.out.println("Test x*y==5");
		System.out.println("x: " + x);
		
		if (x<y) 			x *= 2;
		System.out.println("Test x<y");
		System.out.println("x: " + x);
		
		if (x>y) 			x++;
		System.out.println("Test x>y");
		System.out.println("x: " + x);
				
	}
}