package DynamicProgram;

public class MinPalinCut {
	int minPalinCut(String string){
		int n = string.length();
		boolean[][] isPal = new boolean[n][n];
		int dp[] = new int[n+1]; 
		for (int i = 0; i < n; i++) {
			dp[i] = n - i -1;
		}
		for (int i = n-1; i >= 0; i--) {
			for (int j = i; j < n-1; j++) {
				if (string.charAt(i) == string.charAt(j) && (j-i < 2 || isPal[i+1][j-1])) {
					isPal[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j+1]+1);
				}
			}
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		String string = "abb";
		System.out.println(new MinPalinCut().minPalinCut(string));
	}
}
