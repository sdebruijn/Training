package nl.sijmen.demo;

public class Person {
	private String name;
	private int age;
	private boolean male;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age < 0)
			throw new IllegalArgumentException("Age must be positive");
		this.age = age;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			this.male = true;
		} else if (gender.equalsIgnoreCase("female")) {
			this.male = false;
		} else {
			throw new IllegalArgumentException("Argument must equal male or female");
		}
	}
}
