package nl.sijmen.training;

import java.util.*;

class Player {

	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int lightX = in.nextInt(); // the X position of the light of power
		int lightY = in.nextInt(); // the Y position of the light of power
		int initialTX = in.nextInt(); // Thor's starting X position
		int initialTY = in.nextInt(); // Thor's starting Y position

		// int moveX = lightX - initialTX;
		// int moveY = lightY - initialTY;

		// game loop
		while (true) {
			/*int remainingTurns =*/ in.nextInt();

			String strY = "";
			String strX = "";
			if (lightY < initialTY) { // thor is below light
				strY = "N";
				initialTY--;
			}
			if (lightY > initialTY) { // thor is above light
				strY = "S";
				initialTY++;
			}

			if (lightX < initialTX) {// Thor is right of light
				strX = "W";
				initialTX--;
			}
			if (lightX > initialTX) {// Thor is left of light
				strY = "E";
				initialTX++;
			}

			System.out.println(strY + strX);
		}
	}
}
