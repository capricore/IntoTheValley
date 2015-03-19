package DynamicProgram;

public class MaxSubArray {
	int maxSubArray(int[] A)
	{
		int curMax = 0;
		for (int i = 0; i < A.length; i++) {
			curMax = Math.max(curMax+A[i], A[i]);
		}
		return curMax;
	}
	public static void main(String[] args) {
		int[] A = {-3,1,-3,4,-1,2,1};
		System.out.println(new MaxSubArray().maxSubArray(A));
	}
}
