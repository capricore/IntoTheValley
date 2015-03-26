package DynamicProgram;

public class LongestCommonSubString {
	String LCS(String s1, String s2){
		int n = s1.length(), m = s2.length(), max = 0;
		String result = "";
		if (s1 == null || n == 0 || s2 == null || m == 0) {
			return result;
		}
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i == 0 || j == 0) {
						dp[i][j] = 0;
					}else {
						dp[i][j] = dp[i-1][j-1] + 1;
					}
					if (dp[i][j] > max) {
						max = dp[i][j];
						result = s1.substring(i-max,i+1);
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String s1 = "abdcefg", s2 = "bdcehg";
		System.out.println(new LongestCommonSubString().LCS(s1, s2));
	}
}
