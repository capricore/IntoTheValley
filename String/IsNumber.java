package String;

public class IsNumber {
	public boolean isNumber(String s)
	{
		boolean res = false;
		if (s.equals("")) {
			return res;
		}
		s = s.trim();
		s = s.toLowerCase();
		int length = s.length();
		boolean hasDigit = false, hasExp = false, hasDot = false, hasSign = false;
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (!isValid(c)) {
				return false;
			}
			switch (c) {
			case '+':
			case '-':
				if ((i!=0 && s.charAt(i-1)!='e') || i == length-1) {
					return false;
				}else {
					hasSign = true;
				}
				break;
			case '.':
				if (i == 0 ||  (length== 2 && hasSign) || hasExp || hasDot) {
					return false;
				}else {
					hasDot = true;
				}
				break;
			case 'e':
				if (i == 0 || i == length-1 || hasExp || !hasDigit) {
					return false;
				}else {
					hasExp = true;
				}
				break;
			default:
				hasDigit = true;
				break;
			}
		}
		return true;
	}
	
	public boolean isValid(char c)
	{
		if (c == '+' || c == '-' || c == 'e' || (c >= '0' && c <= '9')) {
			return true;
		}else {
			return false;
		}
	}
}
