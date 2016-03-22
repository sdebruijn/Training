package nl.sijmen.arrayopdrachten;

public class tests {

	public static void main(String[] args) {
		
		final int NLINES = 13;
		int[][] pascal = computePascal(NLINES);
		System.out.println(toString(pascal));
	}

	static int[][] computePascal(int NLINES) {
		int[][] pascal = new int[NLINES][];
		for(int i=0 ; i<NLINES; i++){
			pascal[i] = new int[i+1];
			for(int j=0; j<i+1; j++) {
				if (j==0 || j== i) {
					pascal[i][j] = 1;
				}else {
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				}
			}
		}
		return pascal;
	}
	
	static String toString(int[][] pascal) {
		StringBuilder sb = new StringBuilder(1000);
		for (int[] row : pascal) {
			for (int element : row) {
				sb.append(element + " ");
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
