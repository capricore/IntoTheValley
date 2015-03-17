package DoublePointer;


public class CanJumpII {
	int canJump(int[] A)
	{
		int result = 0;
		int last = 0, current = 0;//last pointer records the most distance of previous round.
		for (int i = 0; i < A.length; i++) {
			if (i > last) {
				last = current;
				result++;
			}
			current = Math.max(current, A[i]+i);
		}
		return result;
	}
	public static void main(String[] args) {
		int[] A = {2,1,3,1,1};
		System.out.println(new CanJumpII().canJump(A));
	}
}
