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
		//������������������������ֱ��ʾ������Ϊ��β�����·����
		int leftValue = getMaxSum(root.left, maxSum);
		int rightValue = getMaxSum(root.right, maxSum);
		//�Ƚ����ߣ���������+���������·���ͣ�����+���������·����
		int currMax = Math.max(root.val, Math.max(root.val+leftValue, root.val+rightValue));
		//�Ƚϵ�ǰ·�������ֵ�͵�ǰ�ڵ�����·��ֵ���Լ��ڵ�ֵ��������·���ĺ����Ƚϣ�ѡ���ֵ��Ϊ��ǰ·�������ֵ��
		maxSum.set(0, Math.max(maxSum.get(0), Math.max(currMax, root.val+leftValue+rightValue)));
		return currMax;
		
	}
}
