package nl.sijmen.training;
/* 
	A company sells five different products whose retail prices are shown in the
	following table. Write a program that asks the user to enter the product number
	and the quantity sold. The program will then calculate and display the total
	retail value.
	product number retail price
	1 2.95
	2 4.99
	3 5.49
	4 7.80
	5 8.85
*/

import java.util.Scanner;

public class Exercise11 {
	
	static Scanner s = new Scanner(System.in);
	
	//static double prices[] = {2.95, 4.99, 5.49, 7.80, 8.85};
	static int prices[] = {295, 499, 549, 780, 885};
	public static void main( String[] args ) {
		int productNumber = inputInt("Enter a product number:");
		System.out.println("Selected product with price: " + prices[productNumber]);
		int quantity = inputInt("Enter the quantity:");
		int total = prices[productNumber]*quantity;
		String str = String.format( "Euro %.2f", total/100.0 );
		System.out.println("Retail value: " + str);
	}
	
	public static int inputInt(String msg){
		while(true) {
			System.out.print(msg + " ");
			if ( s.hasNextInt() ) {
				int i = s.nextInt();
				if (i >= 0) { 
					return i;
				}
			}
			System.out.println("You did not enter an integer...");
			
		}
	}
}