package DynamicProgram;

public class MinimumTotal {
	int minimumTotal(int[][] A)
	{
		int n = A.length;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = A[n-1][i];
		}
		for (int i = n-2; i >= 0; i--) {
			for (int j = 0; j < i+1; j++) {
				result[j] = Math.min(result[j], result[j + 1]) + A[i][j];
			}
		}
		return result[0];
	}
	
	public static void main(String[] args) {
		int[][] A = {{2},{3,4},{6,5,7},{8,3,9,2}};
		System.out.println(new MinimumTotal().minimumTotal(A));
	}
}
