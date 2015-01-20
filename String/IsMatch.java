package String;

public class IsMatch {
	public boolean isMatch(String s, String p)
	{
		if (s == null) {
			return p == null;
		}
		if (p == null) {
			return false;
		}
		return isMatch(s, p, 0, 0);
	}
	
	public boolean isMatch(String s, String p, int i, int j)
	{
		if (j == p.length()) {
			return i == s.length();
		}
		//如果下一个字符不是*的情况
		if (j == p.length() -1 || p.charAt(j+1) != '*') {
			if (i == s.length()) {
				return false;
			}
			return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && isMatch(s, p, ++i, ++j);
		}
		while (i < s.length() && (s.charAt(i) == p.charAt(j))) {
			//跳过*字符，如果匹配到，返回true，否则，继续比较
			if (isMatch(s, p, i, j+2)) {
				return true;
			}
			i++;
		}
		//跳过*字符，方便检查s到头的情况
		return isMatch(s, p, i, j+2);
	}
	
	public static void main(String[] args) {
		String string = "ab";
		String p = "a*";
		System.out.println(new IsMatch().isMatch(string, p));
	}
}
