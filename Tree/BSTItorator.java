package Tree;

import java.util.Iterator;
import java.util.Stack;

public class BSTItorator implements Iterator<TreeNode> {
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	BSTItorator (TreeNode root)
	{
		pushLeft(root);
	}
	
	public boolean hasNext()
	{
		if (stack.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public TreeNode next()
	{
		TreeNode node = stack.pop();
		pushLeft(node.right);
		return node;
	}
	
	public void pushLeft(TreeNode node)
	{
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	@Override
	public void remove() {
	}
}
