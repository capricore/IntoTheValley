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
		//从以保存的结果中找出提取后的单词，加快提取速度
		if (memorized.containsKey(string)) {
			return memorized.get(string);
		}
		//如果整个串就是一个单词，就将他加入到结果中
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
