package nl.sijmen.firstprogram;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise6 {

	static int numTestScores = 0;
	
	public static void main(String[] args) {
		System.out.println("Enter five test scores between 1 and 10");
		
		int sum = 0;
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			int r = readInt();
			if (r > 7)
			{
				count++;
			}
			sum += r;
		}
		System.out.println("\n\nNumber of test results above 7: " + count);
		System.out.println("numTestScores: " + numTestScores);
		System.out.println("Sum    : " + sum);
		System.out.println("Average: " + sum/numTestScores);
	}
	
	public static int readInt()
	{
		int num = 0;
	
		Scanner s = new Scanner(System.in);
		
		boolean loop = true;
		while(loop)
		{
			  try {
	                System.out.print("Input: " + numTestScores + " ");
	                num = s.nextInt();
	                loop = false;
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid value!");
	                s.next(); // Ensure the invalid value is skipped.
	            } 
		}
		s.close();
		
		numTestScores++;
		return num;
	}
}