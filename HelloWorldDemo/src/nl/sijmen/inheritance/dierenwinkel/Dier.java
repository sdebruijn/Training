package nl.sijmen.inheritance.dierenwinkel;

public class Dier {
	private String naam;
    public Dier(String n){this.naam=n;}
    public String getNaam() { return this.naam; }
    public String toString() { return this.getNaam(); }
}