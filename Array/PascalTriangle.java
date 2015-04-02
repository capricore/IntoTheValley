package Array;

import java.util.ArrayList;

public class PascalTriangle {
	ArrayList<ArrayList<Integer>> pascalTriangle(int n){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(1);
		result.add(row1);
		if (n == 1) {
			return result;
		}
		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(1);
		row2.add(1);
		result.add(row2);
		if (n == 2) {
			return result;
		}
		for (int i = 2; i < n; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			row.add(1);
			for (int j = 1; j < i; j++) {
					row.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
			}
			row.add(1);
			result.add(row);
		}
		return result;
	}
	
	public static void main(String[] args) {
		for (ArrayList<Integer> list : new PascalTriangle().pascalTriangle(5)) {
			System.out.println(list);
		}
	}
}
