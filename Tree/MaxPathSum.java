package Tree;

import java.util.ArrayList;

public class MaxPathSum {
	public int maxPathSum(TreeNode	root)
	{
		ArrayList<Integer> maxSum = new ArrayList<Integer>(1);
		maxSum.add(Integer.MIN_VALUE);
		getMaxSum(root , maxSum);
		return maxSum.get(0);
	}
	
	
	public int  getMaxSum(TreeNode root, ArrayList<Integer> maxSum) {
		if (root == null) {
			return 0;
		}
		//左右子树各返回两个结果：分别表示以子树为结尾的最大路径和
		int leftValue = getMaxSum(root.left, maxSum);
		int rightValue = getMaxSum(root.right, maxSum);
		//比较三者：自身，自身+左子树最大路径和，自身+右子树最大路径和
		int currMax = Math.max(root.val, Math.max(root.val+leftValue, root.val+rightValue));
		//比较当前路径的最大值和当前节点的最大路径值，以及节点值加上左右路径的和做比较，选最大值作为当前路径的最大值。
		maxSum.set(0, Math.max(maxSum.get(0), Math.max(currMax, root.val+leftValue+rightValue)));
		return currMax;
		
	}
}
