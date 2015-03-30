package DepthorBreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
	int wordLadder(String start, String end, HashSet<String> dict){
		Queue<String> curLev = new LinkedList<>();
		HashSet<String> used = new HashSet<>();
		curLev.add(start);
		int count = 1;
		if (start.equals(end)) {
			return count;
		}
		while (curLev.size() > 0) {
			Queue<String> nextLev = new LinkedList<>();
			count++;
			while (curLev.size() > 0) {
				String word = curLev.poll();
				for (String string : getTransformation(word, used, dict, end)) {
					if (string.equals(end)) {
						return count;
					}
					nextLev.add(string);
				}
			}
			curLev = nextLev;
		}
		return 0;
	}
	
	ArrayList<String> getTransformation(String word, HashSet<String> used, HashSet<String> dict, String end){
		char[] chars = word.toCharArray();
		char change;
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			change = chars[i];
			for (char j = 'a'; j <= 'z'; j++) {
				if (chars[i] != j) {
					chars[i] = j;
					String afString = new String(chars);
					if (afString.equals(end) || (!used.contains(afString) && dict.contains(afString))) {
						used.add(afString);
						result.add(afString);
					}
				}

			}
			chars[i] = change;
		}
		return result;
	}
	
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("lot");
		dict.add("dot");
		dict.add("dog");
		dict.add("log");
		System.out.println(new WordLadder().wordLadder("hit", "cog", dict));
	}
}
