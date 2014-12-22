package Tree;

import java.util.ArrayList;

public class PathSumII {
	public ArrayList<ArrayList<Integer>> findPathSum(TreeNode root, int sum)
	{
		ArrayList<Integer> path = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		findPathSumHelper(root,sum,path,result,0);
		return result;
	}
	
	public void findPathSumHelper(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result, int level)
	{
		if (root == null) {
			return;
		}
		path.add(root.val);
		if (root.right == null && root.left == null) {
			int tmp = sum;
			for (int i = level; i >= 0; i--) {
				tmp -= path.get(i);
				if (tmp == 0) {
					copyList(path,i,level,result);
				}
			}
		}else {
			findPathSumHelper(root.left, sum, path, result, level+1);
			findPathSumHelper(root.right, sum, path, result, level+1);
		}
		path.remove(path.size()-1);
	}
	
	public void copyList(ArrayList<Integer> path, int from, int end, ArrayList<ArrayList<Integer>> result)
	{
		ArrayList<Integer> subPath = new ArrayList<Integer>();
		for (int i = from; i <= end; i++) {
			subPath.add(path.get(i));
		}
		result.add(subPath);
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
		ArrayList<ArrayList<Integer>> result = new PathSumII().findPathSum(root, 9);
		for (ArrayList<Integer> arrayList : result) {
			System.out.println(arrayList.toString());
		}
	}
}
