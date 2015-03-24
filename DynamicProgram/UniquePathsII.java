package DynamicProgram;

public class UniquePathsII {
	int uniquePaths(int[][] A)
	{
		int m = A.length;
		int n = A[0].length;
		int[] dp = new int[n];
		for (int i = 0; i < m; i++) {
			if (A[i][0] != 1) {
				dp[0] = 1;
			}
			for (int j = 1; j < n; j++) {
				if (A[i][j] != 1) {
					dp[j] = dp[j] + dp[j-1];
				}
			}
		}
		return dp[n-1];
	}
	
	public static void main(String[] args) {
		int[][] A = {{0,1,0,0},{0,0,0,1},{0,0,0,0}};
		System.out.println(new UniquePathsII().uniquePaths(A));
	}
}
