package nl.sijmen.training;

public class Exercise7 {
	static int x = 2;
	static int y = 4;
	
	public static void main(String[] args) {

		printResult();
		if (x * y == 8) {
			x = 1;
		} else {
			x = 2;
		}
		printResult();
		if (x < y) {
			x *= 2;
		} else {
			x++;
		}
		printResult();
		if (x > y) {
			x++;
			y++;
		} else {
			x--;
			y--;
		}
		printResult();
	}
	
	public static void printResult() {
		System.out.println("x: " + x + "   y: " + y);
	}
}