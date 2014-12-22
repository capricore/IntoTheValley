package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> left = new LinkedList<>();
		Queue<TreeNode> right = new LinkedList<>();
		left.add(root.left);
		right.add(root.right);
		while (!left.isEmpty() && !right.isEmpty()) {
			TreeNode leftNode = left.poll();
			TreeNode rightNode = right.poll();
			if (leftNode == null && rightNode == null) {
				continue;
			}
			if (leftNode == null || rightNode == null) {
				return false;
			}
			if (leftNode.val == rightNode.val) {
				left.add(leftNode.left);
				left.add(leftNode.right);
				right.add(rightNode.right);
				right.add(rightNode.left);
			} else {
				return false;
			}
		}
		if (left.isEmpty() && right.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(1);
		System.out.println(new SymmetricTree().isSymmetric(root));
	}
}
