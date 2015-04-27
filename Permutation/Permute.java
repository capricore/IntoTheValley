package Permutation;

import java.util.ArrayList;
import java.util.HashSet;

public class Permute {
	ArrayList<ArrayList<Integer>> permute(int[] A){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//		ArrayList<Integer> path = new ArrayList<>();
//		HashSet<Integer> used = new HashSet<>();
		dfs(A,0,3);
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
	
	void dfs(int[] A,int first, int length){
		if (first == length) {
			for (int i = 0; i < A.length; i++) {
				System.out.print(A[i]);
			}
			System.out.println();
			return;
		}
		for (int i = first; i < A.length; i++) {
			swap(A,first,i);
			dfs(A, first+1, length);//这里是first+1是因为当213输出之后，1和3还需要交换，如果写成i+1的话，就表示1和2交换之后就没有后续了，1和3不会再交换了。
			swap(A,first,i);
		}
	}
	
	
	void swap(int[] A, int x, int y){
		int a = A[x];
		A[x] = A[y];
		A[y] = a;
	}
	public static void main(String[] args) {
		int[] A = {1,2,3};
		ArrayList<ArrayList<Integer>> result = new Permute().permute(A);
		for (ArrayList<Integer> arrayList : result) {
			System.out.println(arrayList);
		}
	}
}
