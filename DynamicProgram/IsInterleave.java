package DynamicProgram;

public class IsInterleave {
	boolean isInterleave(String s1, String s2, String s3)
	{
		int m = s1.length(), n = s2.length(), s = s3.length();
		if (m + n != s) {
			return false;
		}
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true; //null string can be made up of null string.
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if (dp[i][j] || (i - 1 >= 0) && s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j] == true || 
						(j - 1 >= 0) && s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]) {
					dp[i][j] = true;
				}else {
					dp[i][j] = false;
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		String s3 = "adbecf";
		System.out.println(new IsInterleave().isInterleave(s1, s2, s3));
	}
}
