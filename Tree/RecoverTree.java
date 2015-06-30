package Tree;

public class RecoverTree {
	@SuppressWarnings("unused")
	public void recoverTree(TreeNode root)
	{
		if (root == null) {
			return;
		}
		TreeNode firstNode = null;
		TreeNode secondNode = null;
		TreeNode prevNode = null;
		recoverTree(root,firstNode, secondNode , prevNode);
		if (firstNode != null && secondNode != null) {
			int temp = firstNode.val;
			firstNode.val = secondNode.val;
			secondNode.val = temp;
		}
	}
	
	public void recoverTree(TreeNode root, TreeNode n1, TreeNode n2, TreeNode pre) {
		if (root == null) {
			return;
		}
		recoverTree(root.left, n1, n2, pre);
		if (pre != null) {
			if (root.val < pre.val) {
				if (n1 == null) {
					n1 = pre;
					n2 = root;
				}else {
					n2 = root;
				}
			}
		}
		pre = root;
		recoverTree(root.right, n1, n2, pre);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(1);
		new RecoverTree().recoverTree(root);
	}
}
