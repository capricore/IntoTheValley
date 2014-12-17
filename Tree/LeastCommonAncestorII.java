package Tree;

public class LeastCommonAncestorII {
	TreeNode LCA2(TreeNode root, TreeNode right, TreeNode left)
	{
		if (root == null || right == null || left == null) {
			return null;
		}
		TreeNode rlnode = new TreeNode(0);
		help(root, left, right, rlnode);
		TreeNode ll = rlnode.left , rr = rlnode.right;
		if (ll == null || rr == null) {
			return null;
		}
		int lengl = 0, lengr = 0;
		TreeNode prel = ll, prer = rr;
		while (prel != root) {
			prel = prel.parent;
			lengl++;
		}
		while (prer != right) {
			prer = prer.parent;
			lengr++;
		}
		prel = ll;
		prer = rr;
		while(lengl > lengr)
		{
			prel = prel.parent;
			lengl--;
		}
		while (lengl < lengr) {
			prer = prer.parent;
			lengr--;
		}
		while (prel != prer) {
			prel = prel.parent;
			prer = prer.parent;
		}
		return prel;
	}
	void help(TreeNode root, TreeNode p, TreeNode q, TreeNode pq)
	{
		if (root == null ) {
			return;
		}
		if (root == p) {
			pq.left = p;
		}
		if (root == q) {
			pq.right = q;
		}
		if (p == null || q == null) {
			help(root.left, p, q, pq);
			help(root.right, p, q, pq);
		}
	}
}
