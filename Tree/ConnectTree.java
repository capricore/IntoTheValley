package Tree;
class TreeLinkNode
{
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	TreeLinkNode(int val)
	{
		this.val = val;
		next = null;
		left = null;
		right = null;
		
	}
}
public class ConnectTree {
	public void connectTree(TreeLinkNode root)
	{
		if (root == null) {
			return;
		}
		TreeLinkNode currentLve = root;
		while (currentLve != null) {
			TreeLinkNode across = currentLve;
			while (across != null) {
				if (across.left != null) {//������������
					across.left.next = across.right;
				}
				
				if (across.right != null && across.next != null) {//����ͬһ��Ĳ�ͬ���ڵ����������
					across.right.next = across.next.left;
				}
				
				across = across.next;
			}
			
			currentLve = currentLve.left;//ת����һ��
		}
	}
}
