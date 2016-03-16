package nl.sijmen.patterns;
/* 
 * Denk aan een logger.
 */

public class Singleton {
	private static Singleton _instance;
	
	private Singleton() { 
		_instance = this;
	}
	
	public static Singleton getInstance() {
		if (_instance == null) {
			new Singleton();
		}
		return _instance;
	}
	
}