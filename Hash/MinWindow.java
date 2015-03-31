package Hash;

import java.util.HashMap;

public class MinWindow {
	String minWindow(String s, String t){
		HashMap<Character, Integer> toFind = new HashMap<>();
		int count = 0, start = 0, minLen = Integer.MAX_VALUE, minStart = 0;
		for (int i = 0; i < t.length(); i++) {
			if (toFind.containsKey(t.charAt(i))) {
				toFind.put(t.charAt(i), toFind.get(t.charAt(i))+1);
			}else {
				toFind.put(t.charAt(i), 1);
			}
		}
		HashMap<Character, Integer> hasFind = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!toFind.containsKey(c)) {
				continue;
			}
			if (hasFind.containsKey(c)) {
				hasFind.put(c, hasFind.get(c)+1);
			}else {
				hasFind.put(c, 1);
			}
			if (hasFind.get(c) <= toFind.get(c)) {
				count++;
			}
			if (count >= t.length()) {
				char f = s.charAt(start);
				while (hasFind.containsKey(f) == false || hasFind.get(f) > toFind.get(f)) {
					if (hasFind.containsKey(f)) {
						hasFind.put(f, hasFind.get(f)-1);
					}
					start++;
					f = s.charAt(start);
				}
				int length = i - start + 1;
				if (length < minLen) {
					minLen = length;
					minStart = start;
				}
			}
		}
		if (minLen > 0) {
			String result = s.substring(minStart, minStart + minLen);
			return result;
		}else {
			return "";
		}
	}
	
	public static void main(String[] args) {
		String s = "AFEGCABC", t = "FACE";
		System.out.println(new MinWindow().minWindow(s, t));
	}
}
