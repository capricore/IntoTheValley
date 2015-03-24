package DynamicProgram;

public class NumDecoding {
	int numDecoding(String s){
		int length = s.length();
		int[] dp = new int[length+2];
		if (length == 0) {
			return 0;
		}
		dp[length] = 1;
		dp[length+1] = 0;
		for (int i = length - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {//quite important to judge that whether the char is '0'.
				dp[i] = 0;
			}else {
				dp[i] = dp[i+1];
			}
			
			if (i+1 < length && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
				dp[i] += dp[i+2];
			}
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		String string= "12";
		System.out.println(new NumDecoding().numDecoding(string));
	}
}
