package Array;

import java.util.Arrays;

public class SearchRange {
	int[] searchRange(int[] A, int target){
		int lower = 0, upper = A.length;
		int[] range = {-1, -1};
		while (lower < upper) {
			int mid = (lower + upper)/2;
			if (A[mid] < target) {//判断条件之所以为A[mid] < target是因为要找到最靠近目标值但又比目标值小的元素
				lower = mid + 1;
			}else {
				upper = mid;
			}
		}
		if (A[lower] != target) {
			return range;
		}
		range[0] = lower;
		upper = A.length;
		while (lower < upper) {
			int mid = (lower + upper)/2;
			if (A[mid] > target) {//判断条件之所以为A[mid] 》 target是因为要找到最靠近目标值但又比目标值大的元素
				upper = mid;
			}else {
				lower = mid + 1;
			}
		}
		range[1] = upper - 1;
		return range;
	}
	
	public static void main(String[] args) {
		int[] A = {1,3,3,4,5};
		System.out.println(Arrays.toString(new SearchRange().searchRange(A, 4)));
	}
}
