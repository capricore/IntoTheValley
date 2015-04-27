package DepthorBreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LetterReplace {
	Set<String> letterReplace(String string,
			HashMap<Character, ArrayList<Character>> dict) {
		HashSet<String> result = new HashSet<>();
		dfs(string, dict, result, -1);
		return result;
	}

	void dfs(String string, HashMap<Character, ArrayList<Character>> dict,
			HashSet<String> result, int index) {
		// Solution3:
		// if (index == string.length()) {
		// result.add(string);
		// return;
		// }
		// for (int i = index; i < string.length(); i++) {
		// if (dict.containsKey(string.charAt(i))) {
		// StringBuilder word = new StringBuilder(string);
		// ArrayList<Character> cList = dict.get(word.charAt(i));
		// for (Character character : cList) {
		// word.setCharAt(i, character.charValue());
		// dfs(word.toString(), dict, result, i + 1);
		// }
		// }
		//
		// }
		// dfs(string, dict, result, string.length());
		
		// Solution2:
		// result.add(string);
		// if (index == string.length()) {
		// return;
		// }
		// for (int i = index; i < string.length(); i++) {
		// if (dict.containsKey(string.charAt(i))) {
		// StringBuilder word = new StringBuilder(string);
		// ArrayList<Character> cList = dict.get(word.charAt(i));
		// for (Character character : cList) {
		// word.setCharAt(i, character.charValue());
		// dfs(word.toString(), dict, result, i+1);
		// }
		// }
		//
		// }

		// Solution1:dfs(string, dict, result, -1);
		if (index == string.length() - 1) {
			result.add(string);
			return;
		}
		index++;
		if (dict.containsKey(string.charAt(index))) {
			StringBuilder word = new StringBuilder(string);
			ArrayList<Character> cList = dict.get(word.charAt(index));
			for (Character character : cList) {
				word.setCharAt(index, character.charValue());
				dfs(word.toString(), dict, result, index);
			}
		}
		dfs(string, dict, result, index);
	}

	public static void main(String[] args) {
		HashMap<Character, ArrayList<Character>> dict = new HashMap<>();
		ArrayList<Character> list1 = new ArrayList<>();
		list1.add('@');
		dict.put('a', list1);
		ArrayList<Character> list2 = new ArrayList<>();
		list2.add('E');
		list2.add('3');
		dict.put('e', list2);
		Set<String> result = new HashSet<>();
		result = new LetterReplace().letterReplace("face", dict);
		System.out.println(result);
	}
}
