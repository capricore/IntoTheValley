package Tree;

public class BalanceTree {
	public boolean isBalanced(TreeNode root)
	{
		if (getHeight(root) != -1) {//����ֵΪ-1��������������ƽ�������
			return true;
		}
		return false;
	}
	
	//���ÿ���Ӷ������ĸ߶ȣ�����-1��������ƽ������������򷵻������ĸ߶�
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = getHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = getHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(rightHeight - leftHeight) > 1) {
			return -1;
		}
		return 1 + Math.max(leftHeight, rightHeight);
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
		System.out.println(new BalanceTree().isBalanced(root));
	}
}
