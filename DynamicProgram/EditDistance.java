package DynamicProgram;

public class EditDistance {
	int editDistance(String s1, String s2){
		int len1 = s1.length(), len2 = s2.length();
		if (len1 == 0) {
			return len2;
		}
		if (len2 == 0) {
			return len1;
		}
		int[][] dp = new int[len1+1][len2+1];
		for (int i = 0; i < len1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < len2; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i < len1+1; i++) {
			for (int j = 0; j < len2+1; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					// dp[i-1][j-1],dp[i][j-1],dp[i-1][j] represent replace, delete s2[j-1], delete s1[i-1] respectively. 
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
				}
			}
		}
	}
}
