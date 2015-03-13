package DoublePointer;


public class SortColor {
	public int[] sortColor(int A[]){
		//the first pointer records the boundary of 0 and 1, and the second pointer records the boundary of 1 and 2.
		int p0 = 0, p2 = A.length;
		for (int i = 0; i < p2; i++) {
			if (A[i] == 0) {
				A[i] = A[p0];
				A[p0] = 0;
				p0++;
			}else if(A[i] == 2){
				p2--;
				A[i] = A[p2];
				A[p2] = 2;
				i--;
			}
		}
		return A;
	}
	
	public static void main(String[] args) {
		int A[] = {2,1,0,2,0};
		A = new SortColor().sortColor(A);
	}
}
