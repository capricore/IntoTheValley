package Tree;

public class LeastCommonAncestor {
	TreeNode LCA(TreeNode root, TreeNode right, TreeNode left)
	{
		if (root == null || right == null || left == null) {
			return null;
		}
		if (root.val > right.val && root.val > left.val)
		{
			return LCA(root.left, right, left);
		}else if(root.val < right.val && root.val < left.val)
		{
			return LCA(root.right, right, left);
		}else {
			return root;
		}
	}
}
