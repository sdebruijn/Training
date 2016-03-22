package nl.sijmen.webwinkel.util;

public class Test {
	public static void mustBePositive(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("Argument (" + x + ") must be positive.");
		}
	}
	public static void mustBePositive(int x, String msg) {
		if (x < 0) {
			throw new IllegalArgumentException(msg);
		}
	}

}
