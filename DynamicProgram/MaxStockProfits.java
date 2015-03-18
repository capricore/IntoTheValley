package DynamicProgram;

public class MaxStockProfits {
	int maxProfits(int[] A)
	{
		int length = A.length;
		if (length == 0) {
			return 0;
		}
		int[] currentProfit = new int[length];
		int[] futureProfit = new int[length];
		int low = A[0];
		int high = 0;
		int maxProfit = 0;
		for (int i = 0; i < length; i++) {
			low = Math.min(low, A[i]);
			currentProfit[i] = Math.max(currentProfit[i], A[i] - low);
		}
		
		for (int i = length - 1; i >= 0; i--) {
			high = Math.max(high, A[i]);
			futureProfit[i] = Math.max(futureProfit[i], high - A[i]);
			maxProfit = Math.max(maxProfit, futureProfit[i]);
		}
		return maxProfit;
	}
	
	
	public static void main(String[] args) {
		int[] A = {1,2,-3,5};
		System.out.println(new MaxStockProfits().maxProfits(A));
	}
}
