package nl.sijmen.training;

import java.util.Locale;
import java.util.Scanner;

public class Exercise2 {

	public static void main (String[] args)
	{
		System.out.println("Please enter a temperature (degree Celsius)\nTemp = ");
		
		Scanner s = new Scanner(System.in);
		s.useLocale(Locale.US);
		
		double tC = s.nextDouble();
		double tF = celsiusToFahrenheit(tC);
		System.out.println("Celsius   : " + tC);
		System.out.println("Fahrenheit: " + tF);
		
		s.close();
	}
	
	private static double celsiusToFahrenheit(double tempInDegC)
	{
		return 1.8*tempInDegC + 32;
	}
}