package String;

public class StingToInteger {
	public int atoi(String s)
	{
		if (s.length() == 0 || s == null) {
			return 0;
		}
		boolean isNeg = false;
		int p = 0;
		char c = s.charAt(p);
		if (c == '-') {
			isNeg = true;
		}else  if(c == '+'){
			isNeg = false;
		}
		p++;
		int num = 0;
		while ( p < s.length()) {
			c = s.charAt(p);
			if (c < '0' || c > '9') {
				p++;
				continue;
			}
			if ((num == 214748364 && c > '7') || num > 214748364) {
				num = isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			num = 10*num + c -'0';
			p++;
		}
		return isNeg ? -num : num;
	}
}
