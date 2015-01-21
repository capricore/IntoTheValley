package DoublePointer;

public class RemoveDupplicatesII {
	public int removeDuplicatesII(int A[]){
		if (A.length <= 2) {
			return A.length;
		}
		int index = 0;
		A[index++] = A[0];
		A[index++] = A[1];
		for (int i = 2; i < A.length; i++) {
			if (A[index-2] != A[i]) {
				A[index++] = A[i];
			}
		}
		return index;
	}
}
