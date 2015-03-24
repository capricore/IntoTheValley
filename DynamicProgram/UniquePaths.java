package DynamicProgram;


public class UniquePaths {
	int uniquePaths(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		int[] dp = new int[n];
		for (int i = 0; i < m; i++) {
			dp[0] = 1;
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j-1];
			}
		}
		return dp[n-1];
	}
	
	public static void main(String[] args) {
		int[][] A = new int [3][4];
		System.out.println(new UniquePaths().uniquePaths(A));
	}
}
