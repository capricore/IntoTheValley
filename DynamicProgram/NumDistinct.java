package DynamicProgram;

public class NumDistinct {
	int numDistinct(String s, String l)
	{
		int sLen = s.length();
		int lLen = l.length();
		if (sLen == 0 || lLen == 0 || sLen < lLen) {
			return 0;
		}
		int[][] dp = new int[sLen+1][lLen+1];
		for (int i = 0; i < sLen; i++) {
			dp[i][0] = 1;//null counts as a sub string.
		}
		for (int i = 1; i <= sLen; i++) {
			for (int j = 1; j <= lLen; j++) {
				if (s.charAt(i-1) == l.charAt(j-1)) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[sLen][lLen];
	}
	
	public static void main(String[] args) {
		String s = "aexampplee";
		String l = "example";
		System.out.println(new NumDistinct().numDistinct(s, l));
	}
}
