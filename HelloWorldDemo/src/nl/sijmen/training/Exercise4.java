package nl.sijmen.training;

/*
Write a program that prompts the user to enter the length (L), width (W), and
height (H) of a box. The program will then compute and dis- play the volume
and surface area of the box. (Hint: Volume = L × W × H; Surface area =
2×[(L × W) + (L × H) + (H × W)].) 
*/

import java.util.Scanner;

class Exercise4 {
	private static Scanner s = new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("Please enter the dimensions of a box.");
		
		int L = inputInt("Length: ");
		int W = inputInt("Width : ");
		int H = inputInt("Height: ");
		
		System.out.println("The volume is " + L*H*W);
		System.out.println("The surface area equals " + 2*(L*W+L*H+W*H) );
	}
	public static int inputInt(String msg){
		System.out.print(msg + " ");
		return s.nextInt();
	}
}