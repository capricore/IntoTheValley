package Tree;

public class NextOneOfInorderTraversal {
	public TreeNode inorderSucc(TreeNode p)
	{
		if (p == null) {
			return null;
		}
		if (p.right != null) {
			return findLeftMost(p);
		}else
		{
			TreeNode eNode = p.parent;
			while (eNode != null && p != eNode.left) {
				p = eNode;
				eNode = eNode.parent;
			}
			return eNode;
		}
	}
	
	public TreeNode findLeftMost(TreeNode p)
	{
		TreeNode tmp = p.right;
		while (tmp.left != null) {
			tmp = tmp.left;
		}
		return tmp;
	}
}
