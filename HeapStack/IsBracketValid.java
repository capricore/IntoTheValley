package HeapStack;

import java.util.HashMap;
import java.util.Stack;

public class IsBracketValid {
	boolean isBracketValid(String s){
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if ( !stack.isEmpty() && map.get(stack.peek()) == s.charAt(i)) {
				stack.pop();
			}else {
				stack.push(s.charAt(i));
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}
