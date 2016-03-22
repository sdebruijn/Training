package nl.sijmen.codingame.chasm;

import java.util.*;

/* HARD TEST CASE 
   4, 8, 2, 4
   String commands[] = { "WAIT", "SLOW", "JUMP", "SLOW", "SLOW", "SLOW", "WAIT", "WAIT" };
*/

class Player {
	final static String[] commands = { "WAIT", "JUMP", "SLOW", "SPEED" };
	private static final int WAIT = 0;
	private static final int JUMP = 1;
	private static final int SLOW = 2;
	private static final int SPEED = 3;

	final static int maxVelocity = 50;
	final static int maxLength = 100;

	static int xRoad;
	static int xGap;
	static int xPlatform;

	static int state[][];
	static boolean wins[][];
	static boolean changed;

	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int road = in.nextInt(); // the length of the road before the gap.
		int gap = in.nextInt(); // the length of the gap.
		int platform = in.nextInt(); // the length of the landing platform.

		xRoad = road;
		xGap = road + gap;
		xPlatform = road + gap + platform;

		state = new int[maxLength][maxVelocity];
		wins = new boolean[maxLength][maxVelocity];

		for (int x = 0; x < xPlatform; x++){
			for (int v = 0; v < maxVelocity; v++){
				wins[x][v] = false;
			}
		}

		// Mark all positions on the platform with zero velocity as a winning
		for (int x = xGap; x < xPlatform; x++) {
			state[x][0] = WAIT;
			wins[x][0] = true;
		}

		// Dynamic Programming
		changed = true;
		while (changed) {
			changed = false;
			for (int x = 0; x < xPlatform; x++) {
				for (int v = maxVelocity - 1; v >= 0; v--) {
					if (x - v < 0 || !wins[x][v]){
						continue;
					}
					
					// if x-v is in the gap
					if (xRoad <= x - v && x - v < xGap){
						continue;
					}

					if (wins[x - v][v] == false) {
						update(x - v, v, JUMP); // Jump, since it is equal or
												// better than wait.
					}

					// if any of [x-v,x) in the gap
					if (xGap <= x - v || x < xRoad) {
						if (v + 1 < maxVelocity && wins[x - v][v + 1] == false) {
							update(x - v, v + 1, SLOW); // slow down
						}

						if (v - 1 >= 0 && wins[x - v][v - 1] == false) {
							update(x - v, v - 1, SPEED); // speed up
						}
					}
				}
			}
		}

		// game loop
		while (true) {
			int speed = in.nextInt(); // the motorbike's speed.
			int coordX = in.nextInt(); // the position of the motorbike.

			int c = state[coordX][speed];
			System.out.println(commands[c]);
		}
	}

	static void update(int newX, int newV, int command) {
		state[newX][newV] = command;
		wins[newX][newV] = true;
		changed = true;
	}

	static void printMatrix() {
		for (int x = 0; x < xPlatform; x++) {
			for (int v = 0; v < maxVelocity; v++) {
				System.err.print((wins[x][v] ? "1 " : "0 "));
			}
			System.err.print("\n");
		}
	}
}