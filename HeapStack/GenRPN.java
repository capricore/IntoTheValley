package HeapStack;

import java.util.Stack;

public class GenRPN {
	String genRPN(char[] input){
		String result = "";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '+' || input[i] == '-' || input[i] == '*' || input[i] == '/') {
				if (result == "") {
					result += stack.pop();
				}
				char first = stack.pop();
				result = "(" + first + input[i] + result + ")";
			}else {
				stack.push(input[i]);
			}
		}
		return result;
	}
}
