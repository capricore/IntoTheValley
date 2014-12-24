package Tree;

public class FindClosestBST {
	TreeNode findClosestBST(TreeNode root, int val)
	{
		if (root == null) {
			return null;
		}
		if (root.val == val) {
			return root;
		}
		TreeNode left = findClosestBST(root.left, val);
		TreeNode right = findClosestBST(root.right, val);
		int leftValue = left == null ? Integer.MAX_VALUE : Math.abs(left.val - val);
		int rightValue = right == null ? Integer.MAX_VALUE : Math.abs(right.val - val);
		int rootValue = Math.abs(root.val - val);
		int closest = Math.min(leftValue, Math.min(rightValue, rootValue));
		if (closest == leftValue) {
			return left;
		}else if (closest == rightValue) {
			return right;
		}else{
			return root;
		}
	}
}
