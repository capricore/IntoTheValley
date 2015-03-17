package DoublePointer;

import java.util.ArrayList;

public class GetMagnitudePole {
	int getMagnitudePole(int[] A)
	{
		int max = 0;
		ArrayList<Integer> candidateList = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				candidateList.add(A[i]);
				max = A[i];
			}
		}
		int min = A[A.length-1];
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i]< min) {
				if (candidateList.contains(A[i])) {
					return i;
				}
				min = A[i];
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {1,0,1,0,1,2,3};
		System.out.println(new GetMagnitudePole().getMagnitudePole(A));
	}
}
