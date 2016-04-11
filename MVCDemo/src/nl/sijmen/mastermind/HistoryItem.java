package nl.sijmen.mastermind;

public class HistoryItem {
	private int[] guess;
	private int[] hint;
	
	public int[] getGuess() {
		return guess;
	}
	public void setGuess(int[] guess) {
		this.guess = guess;
	}
	public int[] getHint() {
		return hint;
	}
	public void setHint(int[] hint) {
		this.hint = hint;
	}
	
	public HistoryItem() {
	}
	
	public HistoryItem(int[] guess, int[] hint) {
		this.guess = guess;
		this.hint = hint;
	}
	
}