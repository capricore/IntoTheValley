package Hash;

import java.util.ArrayList;
import java.util.HashMap;

public class FindSubstring {
	ArrayList<Integer> findSubString(String S, ArrayList<String> L){
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<String, Integer> toFind = new HashMap<>();
		for (int i = 0; i < L.size(); i++) {
			String s = L.get(i);
			if (toFind.containsKey(s)) {
				toFind.put(s, toFind.get(s)+1);
			}else {
				toFind.put(s, 1);
			}
		}
		HashMap<String, Integer> hasFind = new HashMap<>();
		int length = L.size()*L.get(0).length();
		for (int i = 0; i < S.length() - length; i++) {
			int count = 0;
			for (int j = 0; j < L.size(); j++) {
				String s = S.substring(i+j*L.get(0).length(), i+(j+1)*L.get(0).length());
				if (!toFind.containsKey(s)) {
					break;
				}
				if (hasFind.containsKey(s)) {
					hasFind.put(s, hasFind.get(s)+1);
				}else {
					hasFind.put(s, 1);
				}
				if (hasFind.get(s) <= toFind.get(s)) {
					count++;
				}
				if (count == L.size()) {
					result.add(i);
					i += L.get(0).length()-1;
				}
			}
			hasFind.clear();
		}
		return result;
	}
	
	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		ArrayList<String> L = new ArrayList<>();
		L.add("foo");
		L.add("bar");
		System.out.println(new FindSubstring().findSubString(S, L));
	}
}
