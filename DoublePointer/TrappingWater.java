package DoublePointer;

public class TrappingWater {
	int trappingWater(int[] A)
	{
		if (A.length < 2) {
			return 0;
		}
		int start = 0, end = A.length-1, maxWater = 0;//Two pointers at start and end respectively.
		while (start < end) {
			int area = (end - start)*Math.min(A[start], A[end]);
			maxWater = Math.max(area, maxWater);
			if (A[start] < A[end]) {
				start++;
			}else {
				end--;
			}
		}
		return maxWater;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,3,3,2};
		System.out.println(new TrappingWater().trappingWater(A));
	}
}
