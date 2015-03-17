package DoublePointer;

public class CanJump {
	boolean canJump (int A[])
	{
		if (A.length < 1) {
			return true;
		}
		int maxDis = 0;//Two pointers, one scans the current value, the other one records the max distance.
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0 && maxDis < i+1) {
				return false;
			}
			if (A[i] + i > maxDis && A[i] > 0) {
				maxDis = A[i] + i;
				if (maxDis >= A.length-1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		CanJump canJump = new CanJump();
		int[] A ={2,1,0,1,1};
		System.out.println(canJump.canJump(A));
	}
}
 