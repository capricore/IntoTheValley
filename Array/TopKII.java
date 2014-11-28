package Array;

import java.util.ArrayList;

/* 给定一维整形数组和一个整数k，找出和不小于k的数目最少的子数组 */

public class TopKII
{
	public int partitionII(int[] A, int p, int r,ArrayList<Integer> currentSum)//不同与以往的partition函数，这个执行完后数组是降序的
	{
		if (p > r)
		{
			return -1;
		}
		int i = p-1;
		int temp = A[p];
		int sum = 0;
		for (int j = p; j < r; j++)
		{
			if (A[j] > A[r])
			{
				i++;
				temp = A[j];
				A[j] = A[i];
				A[i] = temp;
			}
		}
		i++;
		temp = A[i];
		A[i] = A[r];
		A[r] = temp;
		for (int j = p; j <= i; j++)
		{
			sum +=  A[j];
		}
		currentSum.set(0 , new Integer(sum));
		return i;
	}
	
	public void getTopKII(int[] data , int k)
	{
		int start = 0;
		int end = data.length - 1;
		int last = -1;//记录上次的子数组和不小于k的尾部元素下标
		ArrayList<Integer> currentSum = new ArrayList<Integer>();//用list记录左半部分的和
		currentSum.add(0);
		int index = partitionII(data, start, end, currentSum);
		while (index >= 0)
		{
			if (currentSum.get(0) >= k)
			{
				last = index;//记录当前下标，因为找到了0到index子数组满足和不小于k的条件
				end = index -1;
				index = partitionII(data, start, end, currentSum);
			}else {
				start = index + 1;
				k = k - currentSum.get(0);//因为更新了start，所以要忽略start之前的元素，所以需要调整k
				index = partitionII(data, start, end, currentSum);
			}
		}
		for (int i = 0; i <= last; i++)
		{
			System.out.println(data[i]);
		}
	}
	public static void main(String[] args)
	{
		TopKII topKII = new TopKII();
		int[] data = {4,2,3,7,5,1};
		topKII.getTopKII(data, 20);
	}
}
