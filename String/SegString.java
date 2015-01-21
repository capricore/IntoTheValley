package String;

import java.util.HashSet;

public class SegString {
	public int segString(String s, HashSet<String> d) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int dp[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(0, i + 1);
			if (d.contains(sub)) {
				dp[i] = 1;
			}
		}

		for (int i = 0; i < s.length() - 1; i++) {
			if (dp[i] > 0) {
				for (int j = i + 1; j < s.length(); j++) {
					String sub = s.substring(i + 1, j + 1);
					if (d.contains(sub)) {
						dp[j] = Math.max(dp[j], dp[i] + 1);
					}
				}
			}
		}
		return dp[s.length() - 1];
	}

	public static void main(String[] args) {
		SegString segString = new SegString();
		HashSet<String> d = new HashSet<String>();
		d.add("this");
		d.add("is");
		d.add("an");
		d.add("example");
		String string = "thisisanexample";
		System.out.println(segString.segString(string, d));
	}
}
