package leetcode.arrays.easy;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return -1;
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            if (prices[i] > min)
                maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }
}
