package Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class ZizaglevelOrder {
	public ArrayList<ArrayList<Integer>> zizaglevelOrder(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}
		LinkedList<TreeNode> currLevel = new LinkedList<TreeNode>();
		currLevel.add(root);
		boolean leftToright = true;
		while (currLevel.size() > 0) {
			ArrayList<Integer> currList = new ArrayList<Integer>();
			LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
			while (currLevel.size() > 0) {
				TreeNode node = currLevel.poll();
				if (node.left != null) {
					nextLevel.add(node.left);
				}
				if (node.right != null) {
					nextLevel.add(node.right);
				}
				if(leftToright)
				{
					currList.add(node.val);
				}else {
					currList.add(0,node.val);
				}
			}
			res.add(currList);
			currLevel = nextLevel;
			leftToright = !leftToright;
		}
		return res;
	}
}
