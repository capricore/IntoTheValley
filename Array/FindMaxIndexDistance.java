package Array;

public class FindMaxIndexDistance
{
	public int maxIndexDistance(int[] A)
	{
		int min = A[0];
		boolean[] inDescSeq = new boolean[A.length];
		inDescSeq[0] = true;
		for (int i = 1; i < inDescSeq.length; i++)
		{
			if (A[i] < min)
			{
				inDescSeq[i] = true;// make a sign of decline
				min = A[i];
			}
		}
		
		int maxDistance = 0, i = A.length - 1, j = A.length - 1;
		while ( i>0 )
		{
			while (inDescSeq[i] == false)
			{
				i--;//find the next element in the descending sequence
			}
			
			while (A[i] >= A[j] && i < j)
			{
				j--;//find the element correspond to the demand
			}
			maxDistance = Math.max(maxDistance, j-i);
			i--;
		}
		return maxDistance;
	}
	
	public static void main(String[] args)
	{
		FindMaxIndexDistance findMaxIndexDistance = new FindMaxIndexDistance();
		int[] A = {5,3,4,1,1,4,0};
		System.out.println(findMaxIndexDistance.maxIndexDistance(A));
	}
}
