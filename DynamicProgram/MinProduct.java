package DynamicProgram;


public class MinProduct {
	int minProduct(int[] A, int[] B)
	{
		int m = A.length, n = B.length;
		int[][] dp = new int[m][n];
		//dp[i][j] = A[i]*B[j], i=j=0;
		//dp[i][j] = min(A[i]*B[j],dp[i][j-1]),i=0,i<=j<i+n-m+1;
		//dp[i][j] = min(A[i]*B[j]+dp[i-1][j-1],dp[i][j-1]),i>0,i<=j<i+n-m+1.
		for (int i = 0; i < m; i++) {
			for (int j = i; j < i+n-m+1; j++) {
				if (j > i) {
					if (i > 0) {
						dp[i][j] = Math.min(A[i]*B[j] + dp[i-1][j-1], dp[i][j-1]);
					}else {
						dp[i][j] = Math.min(A[i]*B[j], dp[i][j-1]);
					}
				}else {
					if (i == 0) {
						dp[i][j] = A[i]*B[j];
					}else {
						dp[i][j] = A[i]*B[j] + dp[i-1][j-1];
					}
				}
			}
		}
		return dp[m-1][n-1];
	}
	
	public static void main(String[] args) {
		int[] A = {1,-1};
		int[] B = {1,2,3,4};
		System.out.println(new MinProduct().minProduct(A, B));
	}
}
