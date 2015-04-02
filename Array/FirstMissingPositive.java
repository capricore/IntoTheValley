package Array;

public class FirstMissingPositive
{
	public int firstMissingPositive(int[] A)
	{
		int n = A.length;
		for (int i = 0; i < n; i++)
		{
			if (A[i] > 0 && A[i] <= n)
			{	
				if (A[i] -1 != i && A[A[i]-1] != A[i])
				{
					int temp = A[i];
					A[i] = A[A[i]-1];
					A[temp-1] = temp;
//					i--;
				}
			}
		}
		for (int i = 0; i < A.length; i++)
		{
			if (A[i]-1 != i)
			{
				return i+1;
			}
		}
		return n+1;
	}
	
	public static void main(String[] args)
	{
		int[] A = {5,3,2,1};
		System.out.println(new FirstMissingPositive().firstMissingPositive(A));
	}
}
