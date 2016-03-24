package nl.sijmen.training;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> list = new ArrayList<Person>();
		
		Person a = new Person("Albert");
		Person b = new Person("Berend");
		Person c = new Person("Cesar");
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(a);
		
		System.out.println("before: " + list);
		
		Person[] arr = new Person[list.size()]; 
				arr = list.toArray(arr);
		
		System.out.println("bf: " + list);
		
		for (Person i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr[2].name = "129084";
		
		System.out.println("af: " + list);
		
		for (Person i : arr) {
			System.out.print(i + " ");
		}
		
	}

}


class Person {
	String name;
	Person(String n) { 
		name = n;
	}
	public String toString() {
		return name;
	}
}