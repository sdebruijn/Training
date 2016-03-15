package nl.sijmen.training;

import java.util.Scanner;

public class IODemo {

	public static void main(String[] args) {
		System.out.println("Name: ");
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String name = s.next(); 
		System.out.println("Hello " + name + "! Nice of you to join the traineeship!");
	}

}