package String;

public class IsUniqueCharII {
	public boolean isUniqueCharII(String string)
	{
		int check = 0;
		string = string.toLowerCase();
		for (int i = 0; i < string.length(); i++) {
			int val = string.charAt(i) - 'a';
			if ((check & (1 << val)) > 0) {
				return false;
			}
			check |= (1 << val);
		}
		return true;
	}
}
