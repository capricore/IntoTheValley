package Tree;
class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode(int value)
	{
		val = value;
		left = null;
		right = null;
	}
}
public class TreeToDoublyList {
	TreeNode treeToDoublyList(TreeNode root)
	{
		TreeNode prev = null;//记录当前指针记录的位置
		TreeNode head = null;//记录的头指针
		treeToDoublyList(root, prev, head);
		return head;
	}
	
	void treeToDoublyList(TreeNode p, TreeNode prev, TreeNode head)
	{
		if (p == null) {
			return;
		}
		treeToDoublyList(p.left, prev, head);
		p.left = prev;
		if (prev != null) {
			prev.right = p;
		}else {
			head = p;
		}
		TreeNode right = p.right;
		//将首尾相接，简历循环关系
		head.left = p;
		p.right = head;
		//进入下一个循环之前，更新prev节点
		prev = p;
		treeToDoublyList(right, prev, head);
		
	}
}
