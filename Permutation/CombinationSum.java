package Permutation;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	ArrayList<ArrayList<Integer>> combinationSum (int[] candidates, int target){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		ArrayList<Integer> path = new ArrayList<>();
		search(candidates,0,target,path,result);
		return result;
	}
	
	void search(int[] candidates, int start, int targe, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result){
		if (start > candidates.length) {
			return;
		}
		if (targe == 0) {
			ArrayList<Integer> res = new ArrayList<>(path);
			result.add(res);
		}else {
			for (int i = start; i < candidates.length; i++) {
				if (candidates[i] > targe) {
					break;
				}
				path.add(candidates[i]);
				search(candidates, i, targe - candidates[i], path, result);
				path.remove(path.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,4,7};
		CombinationSum c = new CombinationSum();
		ArrayList<ArrayList<Integer>> result = c.combinationSum(a, 7);
		for (ArrayList<Integer> arrayList : result) {
			System.out.println(arrayList);
		}
	}
}
