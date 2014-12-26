package Tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class FindKNN {
	public void findKNN(TreeNode root, int k, int target)
	{
		if (root == null) {
			return;
		}
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1.intValue());
				int b = Math.abs(o2.intValue());
				if (a > b) {
					return -1;
				}else if (a < b) {
					return 1;
				}else {
					return 0;
				}
			}
		};
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k,comparator);
		findKNN(root, k, target, heap);
		Iterator<Integer> iterator = heap.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().intValue() + target);
		}
		
	}
	
	public void findKNN(TreeNode root, int k, int target, PriorityQueue<Integer> heap)
	{
		if (root == null) {
			return;
		}
		findKNN(root.left, k, target, heap);
		if (heap.size() < k) {
			heap.add(root.val - target);
		}
		else {
			int val = Math.abs(root.val - target);
			int tmp = Math.abs(heap.peek());
			if (val < tmp) {
				heap.poll();
				heap.add(root.val - target);
			}
		}
		findKNN(root.right, k, target, heap);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(2);
		root.right.right = new TreeNode(9);
		FindKNN findKNN = new FindKNN();
		findKNN.findKNN(root, 3, 7);
	}
}
