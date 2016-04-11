package nl.sijmen.mastermind;

import java.util.ArrayList;
import java.util.Random;

public class MastermindState {
	public static final int WRONG = 0;
	public static final int WRONGPOSITION = 1;
	public static final int CORRECT = 2;
	
	private static Random rng = new Random();
	
	private final int length = 4;
	private final int maxColor = 9;
	
	private int tries = 0;
	private ArrayList<HistoryItem> history = new ArrayList<>();
	private int[] code;
	
	public static int getWRONG() {			return WRONG; }
	public static int getWRONGPOSITION() { 	return WRONGPOSITION; }
	public static int getCORRECT() {		return CORRECT; }
	
	public int[] getCode() {
		return code;
	}
	public int getMaxColor() {
		return maxColor;
	}
	public int getTries() {
		return tries;
	}
	public void setTries(int tries) {
		this.tries = tries;
	}
	public ArrayList<HistoryItem> getHistory() {
		return history;
	}
	public int getLength() {
		return length;
	}
	
	public boolean isCode(int[] guess) {
		if (guess == null || guess[0] == -1){
			return false;
		}
		
		tries++;
		int[] hint = computeHint(guess);
		history.add(new HistoryItem(guess, hint));
		
		for (int i = 0; i < length; i++) {
			if ( code[i] != guess[i]) {
				return false;
			}
		}
		return true;
	}
	
	public int[] computeHint(int[] guess) {
		// check length etc.
		if (guess.length != length) {
			return new int[] {-1,-1,-1};
		}
		
		// check correct
		boolean[] isProcessedGuess = new boolean[length]; // index of code is processed
		boolean[] isProcessedCode = new boolean[length]; // index of code is processed
		int nCorrect = 0;
		int nWrongPos = 0;
		int nWrong = length;
		
		for(int i = 0; i < length; i++) {
			if (code[i] == guess[i]) {
				isProcessedGuess[i] = true;
				isProcessedCode[i] = true;
				nCorrect++;
				nWrong--;				
			}
		}
		
		// check correct, but wrong positions
		for(int i= 0; i < length; i++) { // loop over guess
			if (isProcessedGuess[i]) { continue; }
			
			for(int j = 0; j < length; j++ ) {
				if (j == i || isProcessedCode[j]) {
					continue;					
				}
				
				if (code[j] == guess[i]) {
					isProcessedCode[j] = true;
					isProcessedGuess[i] = true;
					nWrongPos++;
					nWrong--;
					break;
				}
			}
		}
		
		return new int[] {nCorrect, nWrongPos, nWrong};
	}
	
	
	public MastermindState() {
		
		code = new int[length];
		for (int i = 0; i < length; i++) {
			code[i] = rng.nextInt(maxColor);
		}
	}
}