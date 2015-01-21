package DoublePointer;

public class RemoveDuplicates {
	public int removeDuplicates(int[] A){
		if (A.length <= 1) {
			return A.length;
		}
		int  i = 0;
		for (int j = 1; i < A.length; j++) {
			if (A[i] != A[j]) {
				i++;
				A[i] = A[j];
			}
		}
		return i+1;
	}
}
