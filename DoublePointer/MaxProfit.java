package DoublePointer;

public class MaxProfit {
	public int maxProfit(int prices[]){
		if (prices.length == 0) {
			return 0;
		}
		int profit = 0;
		int min = prices[0];//first pointer records the minimum price
		for (int i = 1; i < prices.length; i++) {
			//second pointer traverses the array
			min = Math.min(min, prices[i]);
			profit = Math.max(profit, prices[i] - min);//update the maximum profit
		}
		return profit;
	}
}
