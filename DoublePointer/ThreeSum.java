package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	// public ArrayList<ArrayList<Integer>> threeSum(int num[]){
	// ArrayList<ArrayList<Integer>> resSet = new
	// ArrayList<ArrayList<Integer>>();
	// if (num.length < 3) {
	// return resSet;
	// }
	// Arrays.sort(num);//sort the input array.
	// for (int i = 0; i < num.length-2; i++) {
	// if (num[i] > 0) {// if the first num is bigger than 0, then it's
	// unnecessary to move on.
	// break;
	// }
	// if (i > 0 && num[i] == num[i-1]) {//if the num is same with the previous
	// one, skip this num.
	// continue;
	// }
	// int begin = i+1, end = num.length -1;
	// while (begin < end) {
	// int sum = num[i] + num[begin] + num[end];
	// if (sum > 0) {
	// end--;//the sum is too big, move the end pointer.
	// }else if (sum < 0) {
	// begin++;//the sum is too small, move the head pointer.
	// }else {//match a result, put it in the result set.
	// ArrayList<Integer> res = new ArrayList<Integer>();
	// res.add(num[i]);
	// res.add(num[begin]);
	// res.add(num[end]);
	// resSet.add(res);
	// do {//ignore the result that will likely be the same.
	// begin++;
	// } while (num[begin] == num[begin-1] && begin < end);
	// do {
	// end--;
	// } while (num[end] == num[end+1] && begin < end);
	// }
	// }
	// }
	// return resSet;
	// }

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> resSet = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3) {
			return resSet;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (num[i] > 0)
				break;
			if (i > 0 && num[i] == num[i - 1]) {//add i>0 because when i = 0, i-1 is overflowed. And it's for fear of reduplicated calculation.
				continue;
			}
			int start = i + 1, end = num.length - 1;
			while (end > start) {
				int sum = num[i] + num[start] + num[end];
				if (sum > 0) {
					end--;
				}else if (sum < 0) {
					start ++;
				}else {
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(num[i]);
					result.add(num[start]);
					result.add(num[end]);
					resSet.add(result);
					do {
						start++;
					} while (start < end && num[start] == num[start - 1]);//avoid the same result.
					do {
						end--;
					} while (start < end && num[end] == num[end + 1]);//avoid the same result.
				}
			}
		}
		return resSet;
	}
	
	public static void main(String[] args) {
		int[] num = {-2,-1,1,1,2};
		ThreeSum threeSum = new ThreeSum();
		ArrayList<ArrayList<Integer>> resultArrayList = threeSum.threeSum(num);
		for (ArrayList<Integer> arrayList : resultArrayList) {
			System.out.println(arrayList);
		}
		
	}
}
