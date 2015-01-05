package String;

public class IsUniqueChar {
	public boolean isUniqueChar(String string)
	{
		boolean[] charSet = new boolean[256];
		for (int i = 0; i < string.length(); i++) {
			int c = string.charAt(i);
			if (charSet[c]) {
				return false;
			}
			charSet[c] = true;
		}
		return true;
	}	
	
}
