package nl.sijmen.training;
/* 
8. Write a program that asks the user to enter three numbers. The pro- gram will
then determine and print the largest of the three numbers. 
*/
import java.util.Scanner;
import java.util.Locale;
class Exercise8 {
	static Scanner s = new Scanner(System.in).useLocale(Locale.US);
	
	public static void main(String[] args) {
		double n;
		double max = Double.NEGATIVE_INFINITY;
		System.out.println("Please enter three numbers");
		
		for (int i=0; i<3; i++) {
			n = inputDouble("Number " + i + ": ");
			max = Math.max(n,max);
		}
		System.out.println("The largest number is " + max);		
	}
	
	public static double inputDouble(String msg){
		System.out.print(msg + " ");
		return s.nextDouble();
	}
}