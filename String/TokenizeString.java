package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TokenizeString {
	public ArrayList<String> tokenizeString(String string, HashSet<String> d, HashMap<String, ArrayList<String>> memorized)
	{
		ArrayList<String> res = new ArrayList<String>();
		if (string == null || string.length() == 0) {
			return res;
		}
		//���Ա���Ľ�����ҳ���ȡ��ĵ��ʣ��ӿ���ȡ�ٶ�
		if (memorized.containsKey(string)) {
			return memorized.get(string);
		}
		//�������������һ�����ʣ��ͽ������뵽�����
		if (d.contains(string)) {
			res.add(string);
		}
		for (int i = 0; i < string.length(); i++) {
			String subString = string.substring(0, i);
			if (d.contains(subString)) {
				ArrayList<String> subres = tokenizeString(string.substring(i, string.length()), d, memorized);
				for (String segSuffix : subres) {
					if (segSuffix != null) {
						res.add(subString + " " + segSuffix);
					}
				}
			}
		}
		memorized.put(string, res);
		return res;
	}
	
	public static void main(String[] args) {
		HashSet<String> d = new HashSet<String>();
		d.add("this");
		d.add("is");
		d.add("an");
		d.add("example");
		String string = "thisisanexample";
		HashMap<String, ArrayList<String>> memorized = new HashMap<String, ArrayList<String>>();
		TokenizeString tokenizeString = new TokenizeString();
		ArrayList<String> reStrings = tokenizeString.tokenizeString(string, d, memorized);
		System.out.println(reStrings);
	}
}
