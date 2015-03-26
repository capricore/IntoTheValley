package DynamicProgram;


public class LongestPalindrome {
	String longestPalindrome(String s){
		int length = s.length(), maxLen = 1, start = 0;
		if (length <= 1) {
			return s;
		}
		boolean[][] dp = new boolean[length][length];
		for (int i = 0; i < length; i++) {
			dp[i][i] = true;//single character is palindrome.
		}
		for (int i = 0; i < length-1; i++) {
			if (s.charAt(i) == s.charAt(i+1)) {
				dp[i][i+1] = true;
				maxLen = 2;
			}
		}
		
		for (int i = length - 3; i >= 0; i--) {
			for (int j = i+2; j < length; j++) {
				if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
					dp[i][j] = true;
					maxLen = j-i+1;
					start = i;
				}
			}
		}
		
		return s.substring(start, start+maxLen);
	}
	
	public static void main(String[] args) {
		String string = "abcdcbae";
		System.out.println(new LongestPalindrome().longestPalindrome(string));
	}
}
