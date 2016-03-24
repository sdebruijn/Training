package nl.sijmen.inheritance;

public class Pitfall {

	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.x);
		System.out.println(((B)a).x);

	}

}


class A { public int x = 5; }
class B extends A { public int x = 10; }

