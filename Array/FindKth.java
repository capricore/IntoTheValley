package Array;

public class FindKth
{
	public int findKthSortedArrays(int[] A, int[] B, int k)
	{
		int m = A.length, n = B.length;
		if (m > n)
		{
			findKthSortedArrays(B, A, k);
		}
		int left = 0, right = m;
		while (left < right)
		{
			int mid = left + (right - left)/2, j = k-1 - mid;
			if (j >= n || A[mid] < B[j])
			{
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		
		int Aiminus1 = left - 1 >= 0 ? A[left - 1] : Integer.MIN_VALUE;
		int Bj = k-1 - left >= 0 ? B[k-1 - left] : Integer.MIN_VALUE;
		return Math.max(Aiminus1, Bj);
	}
	
	public static void main(String[] args)
	{
		int A[] = {1,2,3};
		int B[] = {4,5,6,7};
		System.out.println(new FindKth().findKthSortedArrays(A, B, 4));
	}
}
