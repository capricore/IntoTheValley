package Permutation;

import java.util.ArrayList;

public class NQueen {
	public void nQueen(int n){
		ArrayList<Integer> result = new ArrayList<>();
		boolean[] used = new boolean[n];
		dfs(n, 0, result ,used);
		return;
	}
	
	void dfs(int n, int start, ArrayList<Integer> result, boolean[] used){
		if (start == n) {
			System.out.println(result);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (used[i]) {
				continue;
			}
			if (!checkSlope(result, i)) {
				continue;
			}
			result.add(i);
			used[i] = true;
			dfs(n, start+1, result, used);
			result.remove(result.size()-1);
			used[i] = false;
		}
	}
	
	boolean checkSlope(ArrayList<Integer> result, int n){
		int i = 0;
		for (Integer integer : result) {
			if (Math.abs(integer - n) == Math.abs(i - result.size())) {
				return false;
			}
			i++;
		}
		return true;
	}
	public static void main(String[] args) {
		new NQueen().nQueen(5);
	}
}
