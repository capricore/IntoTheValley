package DynamicProgram;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxIncrementalSubsequence {
	ArrayList<Integer> maxSubsequence(int[] A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int[] dp = new int[A.length];// dp[i] represents the length of the longest incremental subsequence.
		//dp[i]=max(dp[i],dp[j]+1), j<i and A[j] <= A[i]
		int end = 0, maxCount = 0;//end marks the last element of the longest incremental subsequence.
		for (int i = 0; i < A.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					if (maxCount < dp[i]) {
						maxCount = dp[i];
						hashMap.put(i, j);
						end = i;
					}

				}
			}
		}
		int k = A.length - 1;
		while (k >= 0) {//add the elements to be deleted into the result array.
			while (k > end) {
				result.add(A[k--]);
			}
			k--;
			if (hashMap.containsKey(end)) {
				end = hashMap.get(end);
			}else {
				end = -1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {3,1,2,4,5,3,6,2,7};
		System.out.println(new MaxIncrementalSubsequence().maxSubsequence(A));
	}
}
