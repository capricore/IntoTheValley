package Permutation;

import java.util.ArrayList;

public class SubSets {
	ArrayList<ArrayList<Integer>> subSets(int[] A){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		for (int i = 0; i < A.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
			for (ArrayList<Integer> arrayList : result) {
				temp.add(arrayList);//restore the previous result.
				ArrayList<Integer> list = new ArrayList<>(arrayList);
				list.add(A[i]);
				temp.add(list);
			}
			result = temp;
		}
		return result;
	}
	
	ArrayList<ArrayList<Integer>> subsets(int[] A){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
		dfs(A, 0, path, result);
		return result;
	}
	
	void dfs(int[] A, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result){
		ArrayList<Integer> list = new ArrayList<>(path);
		result.add(list);
		if (start >= A.length) {
			return;
		}

		for (int i = start; i < A.length; i++) {
			path.add(A[i]);
			dfs(A, i+1, path, result);
			path.remove(path.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3};
		ArrayList<ArrayList<Integer>> result = new SubSets().subsets(A);
		for (ArrayList<Integer> arrayList : result) {
			System.out.println(arrayList);
		}
	}
}
