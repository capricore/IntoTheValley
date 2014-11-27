package Array;

/*求一维数组的最小的K个数*/

public class TopK
{
	public int partition(int[] A, int p, int r)
	{
		if (p > r)
		{
			return -1;
		}
		int i = p-1;
		int temp = A[p];
		for (int j = p; j < r; j++)
		{
			if (A[j] < A[r])
			{
				i++;
				temp = A[j];
				A[j] = A[i];
				A[i] = temp;
			}
		}
		i++;
		temp = A[i];
		A[i] = A[r];
		A[r] = temp;
		return i;
	}
	
	public void getTopK(int[] data, int k)
	{
		int start = 0; 
		int end = data.length - 1;
		int index = partition(data, start, end);
		while (index != k-1)
		{
			if (index < k)
			{
				index = partition(data, index+1, end);
			}else {
				index = partition(data, start, index-1);
			}
		}
		for (int i = 0; i < k; i++)
		{
			System.out.println(data[i]);
		}
	}
	
	public static void main(String[] args)
	{
		int[] data = {2,8,7,1,4};
		TopK getTopK= new TopK();
		getTopK.getTopK(data, 3);
	}
}
