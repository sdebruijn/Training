package nl.sijmen.training;
/*
10.Write a script that asks the user, "Are you sure you want to quit [Y, N]?" The
script then checks the user’s input and only accepts the letters Y and N as valid
answers. 
*/

import java.util.Scanner;

public class Exercise10 {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			System.out.print("Are you sure you want to quit [Y, N]? ");
			if (s.hasNext()) {
				String c = s.next();
				if (c.equals("Y")) {
					System.out.println("System will shut down!");
					break;
				} else if (c.equals("N")) {
					System.out.println("OK, I'll do nothing...");
					break;
				} else {
					System.out.println("Wrong input.");
				}
			}
		}
	}
}