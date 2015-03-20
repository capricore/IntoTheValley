package DynamicProgram;


public class MinSubSum {
	int minSubSum(int[][] A)
	{
		int m = A.length;
		int n = A[0].length;
		int[] result = new int[n];
		for (int i = 1; i < n; i++) {
			result[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < m; i++) {
			result[0] += A[i][0];
			for (int j = 1; j < n; j++) {
				result[j] = Math.min(result[j], result[j-1]) + A[i][j];
			}
		}
		return result[n-1];
	}
	
	public static void main(String[] args)
	{
//		MinSubSum minimumPathSum = new MinSubSum();
//		int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
//		System.out.println(minimumPathSum.minSubSum(grid));
		
		 String a = "Programming";  
	        String b = new String("Programming");  
	        String c = "Program" + "ming";  
	          
	        System.out.println(a == b);  
	        System.out.println(a == c);  
	        System.out.println(a.equals(b));  
	        System.out.println(a.equals(c));  
	        System.out.println(b.intern() == c.intern()); 
	}

	
}
