package String;

public class StringMultiply {
	public String multiply(String s1, String s2)
	{
		int l1 = s1.length(), l2 = s2.length();
		int num[] = new int[l1 + l2];
		for (int i = l1 -1 ; i >= 0 ; i--) {
			for (int j = l2 -1; j >= 0; j--) {
				num[i+j+1] += (s1.charAt(i)- '0')*(s2.charAt(j) - '0');
			}
		}
		
		int carry = 0;
		for (int i = num.length - 1; i > 0; i--) {
			num[i] += carry;
			carry = num[i] / 10;
			num[i] %= 10; 
		}
		String result = "";
		boolean zeroFlag = false;
		for (int i = 0; i < num.length; i++) {
			if (!zeroFlag && num[i] == 0) {
				continue;
			}else {
				result += num[i]; 
				zeroFlag = true;
			}
		}
		if (result.equals("")) {
			return "0";
		}
		return result;
	}
	
	public static void main(String[] args) {
		String s1 = "123";
		String s2 = "456";
		StringMultiply stringMultiply = new StringMultiply();
		System.out.println(stringMultiply.multiply(s1, s2));
	}
}
