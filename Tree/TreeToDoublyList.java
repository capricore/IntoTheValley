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
		TreeNode prev = null;//��¼��ǰָ���¼��λ��
		TreeNode head = null;//��¼��ͷָ��
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
		//����β��ӣ�����ѭ����ϵ
		head.left = p;
		p.right = head;
		//������һ��ѭ��֮ǰ������prev�ڵ�
		prev = p;
		treeToDoublyList(right, prev, head);
		
	}
}
