package leetcode.arrays.easy;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] -min);
            }
        }
        return maxProfit;
    }
}
