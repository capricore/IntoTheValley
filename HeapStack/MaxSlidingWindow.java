package HeapStack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
	int val;
	int index;
	Pair(int val, int index){
		this.val = val;
		this.index = index;
	}
}
public class MaxSlidingWindow {
	void maxSlidingWindow(int[] A, int w, int[] B){
		Comparator<Pair> comparator = new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.val < o2.val) {
					return 1;
				}else if (o1.val > o2.val){
					return -1;
				}else if(o1.index < o2.index){
					return 1;
				}else if(o1.index > o2.index){
					return -1;
				}else {
					return 0;
				}
			}
		};
		
		PriorityQueue<Pair> Queue = new PriorityQueue<>(w,comparator);
		for (int i = 0; i < w; i++) {
			Queue.add(new Pair(A[i], i));
		}
		for (int i = w; i < A.length; i++) {
			Pair p = Queue.peek();
			B[i-w] = p.val;
			while (p.index <= i-w) {
				Queue.poll();
				p = Queue.peek();
			}
			Queue.add(new Pair(A[i], i));
		}
		B[A.length-w] = Queue.peek().val;
	}
	public static void main(String[] args) {
		int[] A = {1,3,-1,-3,5,3,6,7};
		int[] B = new int[6];
		new MaxSlidingWindow().maxSlidingWindow(A, 3, B);
		System.out.println(Arrays.toString(B));
	}
}
