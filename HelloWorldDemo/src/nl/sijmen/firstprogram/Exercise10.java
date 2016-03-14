package nl.sijmen.firstprogram;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise10 {

	public static void main(String[] args) {
		System.out.println("Only enter numbers in the range of 1 through 10");
		
		
		while(true)
		{
			int i = readInt();
			System.out.println("You entered an integer! It was " + i);
			System.out.println(" ");
		}
	}
	
	public static int readInt()
	{
		Scanner s = new Scanner(System.in);
		
		int num = 0;
		boolean loop = true;
		while(loop)
		{
			  try {
	                System.out.print("Please input an integer: ");
	                num = s.nextInt();
	                loop = false;
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid value! Only enter whole numbers in the range of 1 through 10");
	                s.next(); // Ensure the invalid value is skipped.
	            } 
		}
		s.close();
		
		return num;
	}
}