package nl.sijmen.training;

import java.util.Scanner;

public class Exercise6 {

	static int numTestScores = 0;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter five test scores between 1 and 10");

		int sum = 0;
		int count = 0;

		for (int i = 0; i < 5; i++) {
			int r = readInt();
			if (r > 7) {
				count++;
			}
			sum += r;
		}
		System.out.println("\n\nNumber of test results above 7: " + count);
		System.out.println("numTestScores: " + numTestScores);
		System.out.println("Sum    : " + sum);
		System.out.println("Average: " + sum / numTestScores);
	}

	public static int readInt() {
		int num = 0;
		System.out.print("Input " + (numTestScores + 1) + ": ");
		while (s.hasNext()) {
			if (s.hasNextInt()) {
				num = s.nextInt();
				if (0 < num && num <= 10)
					break;
			}

			System.out.println("Not an integer between 1 and 10. Try again...");
			System.out.println("Input " + (numTestScores + 1) + ": ");
			s.nextLine(); // Just discard this, not interested...
		}
		numTestScores++;
		return num;
	}
}