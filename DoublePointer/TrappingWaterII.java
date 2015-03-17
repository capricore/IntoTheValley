package DoublePointer;


public class TrappingWaterII {
	int trappingWater(int[] A)
	{
		int highest = 0;
		if (A.length <2) {
			return 0;
		}
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[highest]) {
				highest = i;
			}
		}
		
		int secondHigh = 0, sum = 0;
		for (int i = 0; i < highest; i++) {
			if (A[i] < secondHigh) {
				sum +=Math.min(secondHigh, A[highest]) - A[i]; 
			}
			if (A[i] > secondHigh) {
				secondHigh = A[i];
			}
		}
		secondHigh = 0;
		for (int i = A.length-1; i > highest; i--) {
			if (A[i] < secondHigh) {
				sum +=Math.min(secondHigh, A[highest]) - A[i]; 
			}
			if (A[i] > secondHigh) {
				secondHigh = A[i];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] A = {1,0,2,1,0,1,3,1};
		System.out.println(new TrappingWaterII().trappingWater(A));
	}
}
