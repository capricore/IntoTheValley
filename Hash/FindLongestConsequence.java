package Hash;

import java.util.HashMap;

public class FindLongestConsequence {
	int findLongestConsequence(int[] A){
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLen = 1;
		for (int i : A) {
			if (map.containsKey(i)) {
				continue;
			}
			map.put(i, 1);
			if (map.containsKey(i-1)) {
				maxLen = Math.max(maxLen, merge(map, i-1, i));
			}
			if (map.containsKey(i+1)) {
				maxLen = Math.max(maxLen, merge(map, i, i+1));
			}
		}
		return maxLen;
	}
	
	int merge(HashMap<Integer, Integer> map, int left, int right){
		int upper = right + map.get(right) - 1;
		int lower = left - map.get(left) + 1;
		int length = upper - lower + 1;
		map.put(right, length);
		map.put(left, length);
		return length;
	}
}
