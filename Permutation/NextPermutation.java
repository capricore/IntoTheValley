package Permutation;

import java.util.Arrays;

public class NextPermutation {
	void nextPermutation(int[] A){
		int  pivot = -1;//record the index of the last decreasing turning point
		for (int i = A.length-1; i >= 0; i--) {
			if (A[i] > A[i-1]) {
				pivot = i-1;
				break;
			}
		}
		
		if (pivot >= 0) {
			for (int i = A.length - 1; i > pivot; i--) {
				if (A[i] > A[pivot]) {
					int temp = A[pivot];
					A[pivot] = A[i];
					A[i] = temp;
				}
				Arrays.sort(A, pivot+1, A.length);
				return;
			}
		}else {
			Arrays.sort(A);
			return;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3};
		new NextPermutation().nextPermutation(A);
		System.out.println(Arrays.toString(A));
	}
}
