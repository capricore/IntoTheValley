package DynamicProgram;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxIncrementalSubsequence {
	ArrayList<Integer> maxSubsequence(int[] A)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, Integer> hashMap = new HashMap<Integer,Integer>();
		int[] dp = new int[A.length];//dp[i] represents the length of the maxincrementalSubsequence.
		for (int i = 0; i < A.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[j] >= A[j-1] && j > 0) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
	}
}
