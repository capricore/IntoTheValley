package HeapStack;

import java.util.Stack;

public class FindMaxRectangle {
	int findMaxRectangle(int[] A){
		int length = A.length, area = 0;
		Stack<Integer> stack = new Stack<>();
		stack.add(-1);
		for (int i = 0; i < length; i++) {
			int p = stack.peek();
			if (p < 0 || A[p] <= A[i]) {
				stack.add(i);
			}else {
				p = stack.pop();
				area = Math.max(area, A[p]*(i-stack.peek()-1));
				i--;
			}
		}
		while (stack.peek() != -1) {
			int p = stack.pop();
			area = Math.max(area, A[p]*(length-stack.peek()-1));
		}
		return area;
	}
	
	public static void main(String[] args) {
		int[] A = {2,1,5,6,2,3};
		System.out.println(new FindMaxRectangle().findMaxRectangle(A));
	}
}
