package Permutation;

import java.util.ArrayList;
import java.util.HashSet;

public class Permute {
	ArrayList<ArrayList<Integer>> permute(int[] A){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
		HashSet<Integer> used = new HashSet<>();
		dfs(A,path, result, used);
		return result;
	}
	
	void dfs(int[] A, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result, HashSet<Integer> used){
		if (path.size() == A.length) {
			ArrayList<Integer> clone = new ArrayList<>(path);
			result.add(clone);
			return;
		}
		for (int i = 0; i < A.length; i++) {
			if (used.contains(A[i])) {
				continue;
			}
			path.add(A[i]);
			used.add(A[i]);
			dfs(A, path, result, used);
			path.remove(path.size()-1);
			used.remove(A[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3};
		ArrayList<ArrayList<Integer>> result = new Permute().permute(A);
		for (ArrayList<Integer> arrayList : result) {
			System.out.println(arrayList);
		}
	}
}
