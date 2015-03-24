package DynamicProgram;


public class MinCost {
	int minCost(int h, int[] color){				
		int [][] cost = new int[h][color.length];
		//dp[i][j] = min(dp[i-1][k]) + color[j]; 0 <= k < color.length, k!=j. 
		//dp[i][j] represents number i+1 house which pains the number j+1 color.
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < color.length; j++) {
				if (i == 0) {
					cost[i][j] = color[j];
				}else {
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < color.length; k++) {
						if (j == k) {
							continue;
						}
						min = Math.min(min, cost[i-1][k]); 
					}
					cost[i][j] = min + color[j];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < color.length; i++) {
			min = Math.min(min, cost[h-1][i]);
		}
		return min;
	}
	public static void main(String[] args) {
		int[] color = {2,1,3,6,5};
		System.out.println(new MinCost().minCost(5, color));
	}
}
